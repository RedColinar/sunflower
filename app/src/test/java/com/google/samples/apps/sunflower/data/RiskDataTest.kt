/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.sunflower.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import org.junit.Test
import java.util.*


/**
 * Created by panqiang at 2019-11-15
 */
class RiskDataTest {

    private val client = OkHttpClient()
    private val gson = Gson()

    @Test
    fun login() {
        val body = RequestBody.create(
            MediaType.parse("application/x-www-form-urlencoded"),
            "phone=18017001513&password=eccb50841467bce3ade7a768555f845acdb7a48f"
        )
        val request = Request.Builder()
            .url("https://web.insnail.com/wap/userAuth/login")
            .post(body)
            .addHeader(
                "Cookie",
                "sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22392153980995776512%22%2C%22%24device_id%22%3A%2216e69d768204e0-09972bee309585-4b536e-2073600-16e69d768215c5%22%2C%22props%22%3A%7B%22%24latest_referrer%22%3A%22%22%2C%22%24latest_referrer_host%22%3A%22%22%2C%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%7D%2C%22first_id%22%3A%2216e69d768204e0-09972bee309585-4b536e-2073600-16e69d768215c5%22%7D; UM_distinctid=16e69d7e5073d3-0d0e13445766d-4b536e-1fa400-16e69d7e508b78; CNZZDATA1272970969=1486564338-1573733786-https%253A%252F%252Fweb.insnail.com%252F%7C1573811353; TY_SESSION_ID=d0599c66-f996-4d8d-864b-35d721f8e978; wapLoginInUrl=https%3A%2F%2Fweb.insnail.com%2FdemandEvaluate%2Fv3%2Findex.html%3Fpath%3Dquestion%2F0%26_timestamp%3D1573815555790%23advertisement;"
            )
            .build()

        val response: String? = client.newCall(request).execute().body()?.string()
        val result: Result<LoginResult> =
            gson.fromJson(response!!, object : TypeToken<Result<LoginResult>>() {}.type)

        print(result)
    }

    @Test
    fun testGradeHistory() {

    }

    @Test
    fun testGrade() {
        val answer = """
            {"answers":[
                {"questionId":"12","index":1,"questionStr":"男女有别，保障不同","A":{"answer":"1","answerStr":"男"}},
                {"questionId":"13","index":2,"questionStr":"家有几口，保障不缺失","A":{"answer":"1","answerStr":"单身"}},
                {"questionId":"15","index":4,"questionStr":"家有几口，保障不缺失","A":{"answer":"2","answerStr":"否"}},
                {"questionId":"15","index":4,"questionStr":"家有几口，保障不缺失","A":{"answer":"2","answerStr":"否"}},
                {"questionId":"16","index":5,"questionStr":"记录生日，精确计算保费","A":{"answer":"1986-01-01","answerStr":"1986-01-01"}},
                {"questionId":"17","index":6,"questionStr":"提前告知，投保无烦恼","A":{"answer":"13","answerStr":"无疾病"}},
                {"questionId":"18","index":7,"questionStr":"量入为出，合理定预算","A":{"answer":"0","answerStr":"0"}},
                {"questionId":"20","index":9,"questionStr":"职业无高低，保障需差别","A":{"answer":"1","answerStr":"室内轻体力（行政、管理人员）"}},
                {"questionId":"21","index":10,"questionStr":" 社保有无，保费大不同","A":{"answer":"1","answerStr":"有"}},
                {"questionId":"19","index":8,"questionStr":"量入为出，合理定预算","F":{"answer":"--#--","answerStr":"--#--"}},
                {"questionId":"22","index":11,"questionStr":"出入有车，意外保障不可少","A":{"answer":"2-2","answerStr":"否-否"}},
                {"questionId":"23","index":12,"questionStr":"服务机构，是否在身边","A":{"answer":"上海市","answerStr":"上海市"}},
                {"questionId":"25","index":14,"questionStr":"选择家庭角色，保障优先级","F":{"answer":"1","answerStr":"本人"}}
            ]}
        """.trimIndent()
        val body = FormBody.Builder().add(
            "answers", """
            [
                {"questionId":"12","index":1,"questionStr":"男女有别，保障不同","A":{"answer":"1","answerStr":"男"}},
                {"questionId":"13","index":2,"questionStr":"家有几口，保障不缺失","A":{"answer":"1","answerStr":"单身"}},
                {"questionId":"15","index":4,"questionStr":"家有几口，保障不缺失","A":{"answer":"2","answerStr":"否"}},
                {"questionId":"15","index":4,"questionStr":"家有几口，保障不缺失","A":{"answer":"2","answerStr":"否"}},
                {"questionId":"16","index":5,"questionStr":"记录生日，精确计算保费","A":{"answer":"1986-01-01","answerStr":"1986-01-01"}},
                {"questionId":"17","index":6,"questionStr":"提前告知，投保无烦恼","A":{"answer":"13","answerStr":"无疾病"}},
                {"questionId":"18","index":7,"questionStr":"量入为出，合理定预算","A":{"answer":"0","answerStr":"0"}},
                {"questionId":"20","index":9,"questionStr":"职业无高低，保障需差别","A":{"answer":"1","answerStr":"室内轻体力（行政、管理人员）"}},
                {"questionId":"21","index":10,"questionStr":" 社保有无，保费大不同","A":{"answer":"1","answerStr":"有"}},
                {"questionId":"19","index":8,"questionStr":"量入为出，合理定预算","F":{"answer":"--#--","answerStr":"--#--"}},
                {"questionId":"22","index":11,"questionStr":"出入有车，意外保障不可少","A":{"answer":"2-2","answerStr":"否-否"}},
                {"questionId":"23","index":12,"questionStr":"服务机构，是否在身边","A":{"answer":"上海市","answerStr":"上海市"}},
                {"questionId":"25","index":14,"questionStr":"选择家庭角色，保障优先级","F":{"answer":"1","answerStr":"本人"}}
            ]
        """.trimIndent()
        ).build()
        val t = Date().time
        val request = Request.Builder()
            .url("https://web.insnail.com/wap/demand2_0/getAssessmentResultWx?path=question/0&_timestamp=$t")
            .post(body)
            .header("api-user-agent", "os/wap;token/72f399e3bc2545419c403bdc725e3656v5inR2")
            .header("token", "null")
            .build()
        val response = client.newCall(request).execute()
        print(response.body().toString())
    }

}