package com.codewithre.simedit.data

import com.codewithre.simedit.data.database.models.User
import com.codewithre.simedit.data.pref.UserPreference
import com.codewithre.simedit.data.remote.response.AddSavingResponse
import com.codewithre.simedit.data.remote.response.AddTransacResponse
import com.codewithre.simedit.data.remote.response.AddTransacSavingResponse
import com.codewithre.simedit.data.remote.response.BalanceResponse
import com.codewithre.simedit.data.remote.response.DetailSavingResponse
import com.codewithre.simedit.data.remote.response.DropdownSavingResponse
import com.codewithre.simedit.data.remote.response.HistoryResponse
import com.codewithre.simedit.data.remote.response.InviteResponse
import com.codewithre.simedit.data.remote.response.LogoutResponse
import com.codewithre.simedit.data.remote.response.ResetPassResponse
import com.codewithre.simedit.data.remote.response.SavingLatestResponse
import com.codewithre.simedit.data.remote.response.SavingResponse
import com.codewithre.simedit.data.remote.response.TotalTargetResponse
import com.codewithre.simedit.data.remote.response.TotalTerkumpulResponse
import com.codewithre.simedit.data.remote.response.UpdateProfileResponse
import com.codewithre.simedit.data.remote.response.UserResponse
import com.codewithre.simedit.data.remote.retrofit.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import retrofit2.http.Field

class UserRepository private constructor(
    private val apiService: ApiService,
    private val userPreference: UserPreference
) {
    fun getSession(): Flow<User> {
        return userPreference.getSession()
    }

    suspend fun logout() {
        return withContext(Dispatchers.IO) {
//            apiService.logout()
            userPreference.logout()
        }
    }

    suspend fun getHistory() : HistoryResponse {
        return withContext(Dispatchers.IO) {
            apiService.getHistory()
        }
    }

    suspend fun getTotalBalance() : BalanceResponse {
        return withContext(Dispatchers.IO) {
            apiService.getTotalBalance()
        }
    }

    suspend fun getTotalIncome() : BalanceResponse {
        return withContext(Dispatchers.IO) {
            apiService.getTotalIncome()
        }
    }

    suspend fun getTotalExpense() : BalanceResponse {
        return withContext(Dispatchers.IO) {
            apiService.getTotalExpense()
        }
    }

    suspend fun getTotalSave() : TotalTerkumpulResponse {
        return withContext(Dispatchers.IO) {
            apiService.getTotalSave()
        }
    }

    suspend fun getTotalSaveTarget() : TotalTargetResponse {
        return withContext(Dispatchers.IO) {
            apiService.getTotalSaveTarget()
        }
    }

    suspend fun getUser() : UserResponse {
        return withContext(Dispatchers.IO) {
            apiService.getUser()
        }
    }

    suspend fun getSaving() : SavingResponse {
        return withContext(Dispatchers.IO) {
            apiService.getSaving()
        }
    }

    suspend fun getDropdownSaving() : DropdownSavingResponse {
        return withContext(Dispatchers.IO) {
            apiService.getDropdownSaving()
        }
    }

    suspend fun getDetailSaving(id : Int) : DetailSavingResponse {
        return withContext(Dispatchers.IO) {
            apiService.getDetailSaving(id)
        }
    }
    suspend fun addTransactionSaving(
        status : String,
        nominal : Int,
        portomember_id : Int,
        keterangan : String
    ) : AddTransacSavingResponse {
        return withContext(Dispatchers.IO) {
            apiService.addTransactionSaving(
                status,
                nominal,
                keterangan,
                portomember_id
            )
        }
    }

    suspend fun addTransaction(
        status : String,
        nominal : String,
        tgl : String,
        keterangan : String
        ) : AddTransacResponse {
        return withContext(Dispatchers.IO) {
            apiService.addTransaction(
                status,
                nominal,
                tgl,
                keterangan
            )
        }
    }

    suspend fun addSaving(
        title : String,
        target : Int
    ) : AddSavingResponse {
        return withContext(Dispatchers.IO) {
            apiService.addSaving(
                title,
                target
            )
        }
    }

    suspend fun updateProfile(
        name: String,
        username: String,
        email: String,
    ) : UpdateProfileResponse {
        return withContext(Dispatchers.IO) {
            apiService.updateProfile(
                name,
                username,
                email
            )
        }
    }

    suspend fun resetPass(
        currentPass: String,
        password: String,
        passConfirm: String,
    ) : ResetPassResponse {
        return withContext(Dispatchers.IO) {
            apiService.resetPass(
                currentPass,
                password,
                passConfirm
            )
        }
    }

    suspend fun inviteFriend(
        email : String,
        portoId : Int
    ) : InviteResponse {
        return withContext(Dispatchers.IO) {
            apiService.inviteFriend(
                email,
                portoId
            )
        }
    }

    companion object {
        fun getInstance(
            apiService: ApiService,
            userPreference: UserPreference
        ) = UserRepository(apiService, userPreference)
    }
}