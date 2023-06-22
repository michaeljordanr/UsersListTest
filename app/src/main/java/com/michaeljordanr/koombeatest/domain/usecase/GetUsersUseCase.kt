package com.michaeljordanr.koombeatest.domain.usecase

import com.michaeljordanr.koombeatest.common.Resource
import com.michaeljordanr.koombeatest.domain.UserRepository
import com.michaeljordanr.koombeatest.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {

    operator fun invoke() : Flow<Resource<List<User>>> = flow {
        try {
            emit(Resource.Loading())
            val users = repository.getUsers()
            emit(Resource.Success(users))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check you internet connection."))
        }
    }
}