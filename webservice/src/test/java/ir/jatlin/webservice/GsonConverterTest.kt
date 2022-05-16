package ir.jatlin.webservice

import com.google.common.truth.Truth.*
import ir.jatlin.webservice.di.NetworkModule
import ir.jatlin.webservice.model.movie.MovieDetailsDTO
import ir.jatlin.webservice.model.response.MoviesResponse
import ir.jatlin.webservice.model.response.UpcomingMoviesResponse
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GsonConverterTest {

    private val gson = NetworkModule.provideGson()

    @Test
    fun `parse details of the movie successfully`() {

        val fileName = "movie-detail-response.json"
        val movieDetails = gson.fromJson(
            readResource(fileName),
            MovieDetailsDTO::class.java
        )
        assertThat(movieDetails).isNotNull()
    }

    @Test
    fun `parse popular movies successfully`() {

        val fileName = "popular-movie-response.json"
        val popularMovies = gson.fromJson(
            readResource(fileName),
            MoviesResponse::class.java
        )
        println(popularMovies)
        assertThat(popularMovies).isNotNull()
        assertThat(popularMovies).isInstanceOf(MoviesResponse::class.java)
        assertThat(popularMovies.movieList).isNotNull()
    }

    @Test
    fun `parse discover movies successfully`() {

        val fileName = "discover-movie-response.json"
        val discoverMovies = gson.fromJson(
            readResource(fileName),
            MoviesResponse::class.java
        )
        println(discoverMovies)
        assertThat(discoverMovies).isNotNull()
        assertThat(discoverMovies).isInstanceOf(MoviesResponse::class.java)
        assertThat(discoverMovies.movieList).isNotNull()
    }

    @Test
    fun `parse upcoming movies successfully`() {

        val fileName = "upcoming-response.json"
        val upcomingMovies = gson.fromJson(
            readResource(fileName),
            UpcomingMoviesResponse::class.java
        )
        assertThat(upcomingMovies).isNotNull()
        assertThat(upcomingMovies).isInstanceOf(UpcomingMoviesResponse::class.java)
        assertThat(upcomingMovies.moviesResponse).isNotNull()
    }

    private fun readResource(fileName: String): String? {
        return javaClass.classLoader?.getResource(fileName)?.readText()
    }
}