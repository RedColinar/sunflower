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

package com.google.samples.apps.sunflower.risk.data

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

data class QuestionItem(
    val answerType: String,
    val content: String,
    val id: Int,
    val index: Int,
    val options: String,
    val type: String
)

data class QuestionResult(
    val advice: String,
    val benren: Benren,
    val boundPhoneFlag: Int,
    val demTotalNum: Int,
    val familyallShenGuValue: String,
    val famlyTotalPayAmount: Int,
    val id: String,
    val isSatisfied: Int,
    val memberNumber: Int,
    val priority: String,
    val programInterpretation: Any,
    val recomPremium: RecomPremium
)

data class Benren(
    val buyingOpportunity: BuyingOpportunity,
    val familySupport: FamilySupport,
    val programInterpretation: ProgramInterpretation,
    val recommandProduct2_0: List<RecommandProduct20>,
    val riskAnalysis: RiskAnalysis
)

data class BuyingOpportunity(
    val age: String,
    val diseaseStatus: Int,
    val fiveForLife: Int,
    val fiveForLifeStatus: Int,
    val fiveForRegular: Int,
    val fiveForRegularStatus: Int,
    val myRiskChance: String,
    val myRisklabel: String,
    val relation: String,
    val sex: String,
    val tenForLife: Int,
    val tenForLifeStatus: Int,
    val tenForRegular: Int,
    val tenForRegularStatus: Int
)

data class FamilySupport(
    val age: String,
    val allAccidentGuaranteeList: List<AllAccidentGuarantee>,
    val allAccidentValue: String,
    val allJiBingValue: String,
    val allMedicalCareGuaranteeList: List<AllMedicalCareGuarantee>,
    val allMedicalCareValue: String,
    val allShenGuValue: String,
    val relation: String,
    val sex: String,
    val totalPayAmount: Int,
    val totaljiBingGuaranteeList: List<TotaljiBingGuarantee>,
    val totalshenGuGuaranteeList: List<TotalshenGuGuarantee>
)

data class AllAccidentGuarantee(
    val name: String,
    val value: String
)

data class AllMedicalCareGuarantee(
    val name: String,
    val value: String
)

data class TotaljiBingGuarantee(
    val name: String,
    val value: String
)

data class TotalshenGuGuarantee(
    val name: String,
    val value: String
)

data class ProgramInterpretation(
    val commentList: List<Comment>,
    val oneword: String
)

data class Comment(
    val contentArray: List<String>,
    val maintitle: String,
    val subtitle: String
)

data class RecommandProduct20(
    val amount: String,
    val amountStr: String,
    val comment: String,
    val companyName: String,
    val ensureClass: String,
    val imgUrl: String,
    val insPeriod: String,
    val insProductId: String,
    val insrued: String,
    val payAmount: Double,
    val payAmountStr: String,
    val paymentMode: String,
    val paymentModeId: String,
    val paymentModeTypeId: String,
    val productId: Int,
    val productName: String,
    val productType: Int,
    val productUrl: String,
    val recType: Int,
    val recommands: Int,
    val termId: String,
    val xianzhongName: String,
    val xianzhongNameCn: String
)

data class RiskAnalysis(
    val age: String,
    val comment: String,
    val myRiskProChance: List<String>,
    val relation: String,
    val sex: String
)

data class RecomPremium(
    val label: String,
    val value: String
)