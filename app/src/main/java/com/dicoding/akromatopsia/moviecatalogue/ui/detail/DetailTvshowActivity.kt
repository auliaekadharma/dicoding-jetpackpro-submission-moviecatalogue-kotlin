package com.dicoding.akromatopsia.moviecatalogue.ui.detail

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.akromatopsia.moviecatalogue.R
import com.dicoding.akromatopsia.moviecatalogue.databinding.ActivityDetailMovieBinding
import com.dicoding.akromatopsia.moviecatalogue.databinding.ActivityDetailTvshowBinding
import com.dicoding.akromatopsia.moviecatalogue.databinding.ContentDetailMovieBinding
import com.dicoding.akromatopsia.moviecatalogue.databinding.ContentDetailTvshowBinding

class DetailTvshowActivity : AppCompatActivity() {

    private lateinit var detailContentBinding: ContentDetailTvshowBinding

    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailTvshowBinding = ActivityDetailTvshowBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailTvshowBinding.detailContent

        setContentView(activityDetailTvshowBinding.root)

        setSupportActionBar(activityDetailTvshowBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }
}