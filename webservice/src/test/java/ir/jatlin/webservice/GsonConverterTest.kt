package ir.jatlin.webservice

import com.google.common.truth.Truth
import com.google.common.truth.Truth.*
import ir.jatlin.webservice.di.NetworkModule
import ir.jatlin.webservice.model.movie.MovieDetailsDTO
import ir.jatlin.webservice.model.response.MoviesResponse
import ir.jatlin.webservice.model.response.UpcomingMoviesResponse
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.reflect.KClass

@RunWith(JUnit4::class)
class GsonConverterTest {

    private val gson = NetworkModule.provideGson()

    @Test
    fun `parse details of the movie successfully`() =
        parseAndAssert(
            resourceName = "movie-detail-response.json",
            classType = MovieDetailsDTO::class.java,
        ) { movieDetails ->
            assertThat(movieDetails).isNotNull()
        }


    @Test
    fun `parse popular movies successfully`() = parseAndAssert(
        resourceName = "popular-movie-response.json",
        classType = MoviesResponse::class.java,
    ) { popularMovies ->
        assertThat(popularMovies).isNotNull()
        assertThat(popularMovies).isInstanceOf(MoviesResponse::class.java)
        assertThat(popularMovies.movieList).isNotNull()
    }

    @Test
    fun `parse upcoming movies successfully`() = parseAndAssert(
        resourceName = "upcoming-response.json",
        classType = UpcomingMoviesResponse::class.java,
    ) { upcomingMovies ->
        assertThat(upcomingMovies).isNotNull()
        assertThat(upcomingMovies).isInstanceOf(UpcomingMoviesResponse::class.java)
        assertThat(upcomingMovies.moviesResponse).isNotNull()
    }


    @Test
    fun `parse top rated movies and return successfully`() = parseAndAssert(
        resourceName = "top-rated-movie-response.json",
        classType = MoviesResponse::class.java,
    ) { topRatedMovies ->
        assertThat(topRatedMovies).isNotNull()
        assertThat(topRatedMovies).isInstanceOf(MoviesResponse::class.java)
        assertThat(topRatedMovies.movieList).isNotNull()
    }


    @Test
    fun `parse discover movies successfully`() = parseAndAssert(
        resourceName = "top-rated-movie-response.json",
        classType = MoviesResponse::class.java,
    ) { discoverMovies ->
        assertThat(discoverMovies).isNotNull()
        assertThat(discoverMovies).isInstanceOf(MoviesResponse::class.java)
        assertThat(discoverMovies.movieList).isNotNull()
    }

    private fun <T : Any> parseAndAssert(
        resourceName: String,
        classType: Class<T>,
        assert: (response: T) -> Unit
    ) {
        val json = ResourceProvider.readFrom(resourceName)
        val response = gson.fromJson(json, classType)
        assert(response)
    }

}