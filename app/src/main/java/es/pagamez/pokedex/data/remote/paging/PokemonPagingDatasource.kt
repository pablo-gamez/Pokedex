package es.pagamez.pokedex.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import es.pagamez.pokedex.ConstAndValues
import es.pagamez.pokedex.data.remote.datasource.RemoteDatasource
import es.pagamez.pokedex.data.remote.model.NameUrlDto
import javax.inject.Inject

class PokemonPagingDatasource @Inject constructor(
    private val remote: RemoteDatasource
) : PagingSource<Int, NameUrlDto>() {

    override fun getRefreshKey(state: PagingState<Int, NameUrlDto>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NameUrlDto> {
        val pageNumber = params.key ?: ConstAndValues.STARTING_PAGE_INDEX
        return remote.getPokemonList(
            ConstAndValues.NETWORK_PAGE_SIZE,
            pageNumber * ConstAndValues.NETWORK_PAGE_SIZE
        ).fold(
            onSuccess = {
                LoadResult.Page(
                    data = it.results,
                    prevKey = if (pageNumber > ConstAndValues.STARTING_PAGE_INDEX) pageNumber else null,
                    nextKey = if (it.results.isNotEmpty()) pageNumber.plus(1) else null
                )
            },
            onFailure = { LoadResult.Error(it) }
        )
    }

}