package com.example.navigationdemo.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Util {
    companion object{
        fun getMockNews(): NewsJson {
            val summary = "TÜİK'e göre tüketici enflasyonu ağustosta yüzde 80,21'e yükseldi. ENAG ise enflasyonu yüzde 181,37 olduğunu hesapladı."
            val imageDetail = ImageDetail(10,"https://artpil.com/wp-content/uploads/2019/02/Pablo-Picasso-bio350-self-portrait.jpg",20)
            val imageDetail2 = ImageDetail(10,"https://camiahaber.com/wp-content/uploads/2022/03/Benzin-fiyatlari.jpg",20)
            val imageDetail3 = ImageDetail(10,"https://im.haberturk.com/2019/07/24/ver1563974458/2507393_810x458.jpg",20)
            val imageDetail4 = ImageDetail(10,"https://i.hurimg.com/i/hdn/75/0x0/62bebcaf4e3fe01a60bf2114.jpg",20)
            val imageDetail5 = ImageDetail(10,"",20)
            val newDetail = NewDetail(1,"",summary,1,imageDetail,"0",1,"hurriyet","","","","","")
            val newDetail2 = NewDetail(1,"",summary,1,imageDetail2,"0",1,"sozcu","","","","","")
            val newDetail3 = NewDetail(1,"",summary,1,imageDetail3,"0",1,"sabah","","","","","")
            val newDetail4 = NewDetail(1,"",summary,1,imageDetail4,"0",1,"posta","","","","","")
            val newDetail5 = NewDetail(1,"",summary,1,imageDetail5,"0",1,"macir","","","","","")
            val newJson = NewsJson(0,listOf<New>(
                New(false,"",newDetail,"",false),
                New(false,"",newDetail2,"",false),
                New(false,"",newDetail3,"",false),
                New(false,"",newDetail4,"",false),
                New(false,"",newDetail5,"",false),
                New(false,"",newDetail2,"",false),
                New(false,"",newDetail3,"",false),
                New(false,"",newDetail4,"",false)
            ))
            return newJson
        }
        /*fun getDummyNew(): New {
            val imageDetail : ImageDetail = ImageDetail(10,"https://artpil.com/wp-content/uploads/2019/02/Pablo-Picasso-bio350-self-portrait.jpg",20)
            val newDetail : NewDetail = NewDetail(1,"","Whole Lotta Love",1,imageDetail,"",1,"","","","","","")
            return New(false,"nobody",newDetail,"",false)
        }*/
        fun leftSideOfNews(newJson: NewsJson): List<New> {
            val list = arrayListOf<New>()
            for(i in (0 until newJson.newsList.size)){
                if(i % 2 == 0){
                    list.add(newJson.newsList[i])
                }
            }
            return list
            //return newJson.newsList.subList(0,newJson.newsList.size/2)
        }
        fun rightSideOfNews(newJson: NewsJson) : List<New>{
            val list = arrayListOf<New>()
            for(i in (0 until newJson.newsList.size)){
                if(i % 2 == 1){
                    list.add(newJson.newsList[i])
                }
            }
            return list
            //return newJson.newsList.subList(newJson.newsList.size/2,newJson.newsList.size)
        }
        fun getBodyJsonOfPostRequest(): BundlePostBody {
            val topicIds: List<Int> = listOf(324,2820,2821)
            val requestType = 0
            val includePictures = 1
            return BundlePostBody(topicIds,requestType,includePictures)
        }
        @RequiresApi(Build.VERSION_CODES.O)
        fun getElapsedTime(str:String): String {
            val text = str.replace('T',' ')
            val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
            val localDateTime = LocalDateTime.parse(text, pattern)
            val now = LocalDateTime.now()
            val dif = Duration.between(localDateTime,now)

            var difS = dif.seconds
            var difM : Long = 0
            var difH : Long = 0//
            var difD : Long= 0 // difH / 24
            if(difS >= 60){
                difM = difS / 60
                difS -= difM * 60
                if(difM >= 60){
                    difH = (difM / 60)
                    difM -= difH * 60
                    if(difH >= 24){
                        difD = difH / 24
                        difH -= difD * 24
                    }
                }
            }
            if(difD > 0){
                if(difD.toInt() == 1){
                    return "1 day"
                }
                else{
                    return "$difD days"
                }
            }
            else if(difH > 0){
                if(difH.toInt() == 1){
                    return "1 hour"
                }
                else{
                    return "$difH hours"
                }
            }
            else if(difM > 0){
                if(difM.toInt() == 1){
                    return "1 minute"
                }
                else{
                    return "$difM minutes"
                }
            }
            else{
                if(difS.toInt() == 1){
                    return "1 second"
                }
                else{
                    return "$difS seconds"
                }
            }
        }
    }
}