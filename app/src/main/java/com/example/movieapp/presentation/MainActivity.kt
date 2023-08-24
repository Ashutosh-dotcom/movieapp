package com.example.movieapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.presentation.di.Injector
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory
    private lateinit var movieViewModel:ViewModel
    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter: MovieAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        (application as Injector).createMovieSubComponent().inject(this)

        movieViewModel= ViewModelProvider(this,factory)
            .get(ViewModel::class.java)
        initRecyclerView()

    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager= LinearLayoutManager(this)
        adapter =MovieAdapter()
        binding.recyclerView.adapter =adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        binding.movieProgressBar.visibility= View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()

        responseLiveData.observe(this,  Observer{

            if(it !=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility=View.GONE
            }else{
                binding.movieProgressBar.visibility=View.GONE
                Toast.makeText(applicationContext,"No Data Available",Toast.LENGTH_LONG).show()
            }
        })
    }
}