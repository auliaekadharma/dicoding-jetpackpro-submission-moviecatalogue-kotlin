package com.dicoding.akromatopsia.moviecatalogue.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.akromatopsia.moviecatalogue.R
import com.dicoding.akromatopsia.moviecatalogue.data.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.databinding.FragmentMovieBinding
import com.dicoding.akromatopsia.moviecatalogue.utils.DataDummy

class MovieFragment : Fragment(), MovieFragmentCallback {

    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val movies = DataDummy.generateDummyMovies()
            val movieAdapter = MovieAdapter(this)
            movieAdapter.setMovies(movies)
            with(fragmentMovieBinding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

    override fun onShareClick(movie: MovieEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                    .from(requireActivity())
                    .setType(mimeType)
                    .setChooserTitle("Bagikan aplikasi ini sekarang.")
                    .setText(resources.getString(R.string.share_text, movie.title))
                    .startChooser()
        }
    }

}