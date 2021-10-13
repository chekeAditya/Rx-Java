package com.masai.pagingnetworkand03.ui

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.masai.pagingnetworkand03.api.NetworkHelper
import com.masai.pagingnetworkand03.model.CharacterDTO
import com.masai.pagingnetworkand03.model.ResponseDTO

class CharacterPagingSource : PagingSource<Int,CharacterDTO>() {

    private  val apiService = NetworkHelper.getApiService()

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterDTO> {


        return try {
            //to catch the exception
            val pageNumber = params.key ?:1;
            val responseDTO : ResponseDTO = apiService.getCharactersByPage(pageNumber)
            val characterList:List<CharacterDTO> = responseDTO.results

            LoadResult.Page(
                data = characterList,
                prevKey = null,
                nextKey = if(characterList.isEmpty()) null else pageNumber + 1
            )
        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterDTO>): Int? {
        return state.anchorPosition
    }

}