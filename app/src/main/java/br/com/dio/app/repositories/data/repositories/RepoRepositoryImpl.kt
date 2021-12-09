package br.com.dio.app.repositories.data.repositories

import br.com.dio.app.repositories.data.services.GithubService
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import br.com.dio.app.repositories.core.RemoteException

class RepoRepositoryImpl(private val service: GithubService): RepoRepository {
    override suspend fun listRepositories(user: String) = flow {
        try {
            val repoList = service.listRepositories(user)
            emit(repoList)
        }catch (ex: HttpException){
            throw RemoteException(ex.message())
        }

    }
}