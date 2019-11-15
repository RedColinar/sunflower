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

/**
 * Created by panqiang at 2019-11-15
 */
data class Result<T>(
    var list: Any? = null,
    var message: String = "",
    var params: Any? = null,
    var result: T? = null,
    var status: Int = 0,
    var tag: Any? = null
)

data class LoginResult(
    var auditStatus: Int = 0,
    var birthDay: Any? = null,
    var coopCode: String = "",
    var email: String = "",
    var gender: Int = 0,
    var idCardAuditUrl: String = "",
    var identCardNo: String = "",
    var imgUrl: String = "",
    var invitationCode: String = "",
    var inviteCode: Any? = null,
    var inviteCodeTime: Any? = null,
    var isBound: Int = 0,
    var isGuardians: Int = 0,
    var mktHeadImgUrl: String = "",
    var mktNickname: String = "",
    var name: String = "",
    var nickname: String = "",
    var phone: String = "",
    var privateIdCardAuditUrl: Any? = null,
    var registrationChannelCode: Any? = null,
    var resetPwdFlag: Int = 0,
    var role: Int = 0,
    var snailShell: Int = 0,
    var token: String = "",
    var type: Int = 0,
    var userId: String = ""
)