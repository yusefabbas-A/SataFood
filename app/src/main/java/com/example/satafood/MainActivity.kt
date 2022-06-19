package com.example.satafood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.satafood.adapter.MyAdapter
import com.example.satafood.adapter.OffersAdapter
import com.example.satafood.adapter.SlidAdapter
import com.example.satafood.model.Category
import com.example.satafood.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyAdapter() }
    private val slidAdapter by lazy { SlidAdapter() }
    private val offersAdapter by lazy { OffersAdapter() }
    val cities : ArrayList<String> = arrayListOf<String>("مدينة نصر - الحى العاشر", "التجمع الخامس - النرجس 8", "حلوان - مدينة 15 مايو")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val arrayAdapter = ArrayAdapter(this,R.layout.my_spinner_item,cities)
        spinner.adapter = arrayAdapter

        setupOffersRecycler()
        setupSlidRecycler()
        setupCategoryRecycler()
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getFoodstore()
        viewModel.myResponse.observe(this, Observer{ response ->
            if (response.isSuccessful){
                myAdapter.setData(response.body()?.categories as ArrayList<Category>)
                response.body()?.sliders?.let { slidAdapter.setSlidData(it) }
                response.body()?.newoffers?.let { offersAdapter.setOfferData(it) }
            }
            else{
                Log.d("Response", response.errorBody().toString())
            }

        })
    }



    private fun setupCategoryRecycler(){
        categoryList.adapter = myAdapter
        categoryList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }

    private fun setupSlidRecycler(){
        sliderList.adapter = slidAdapter
        sliderList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }

    private fun setupOffersRecycler(){
        offersList.adapter = offersAdapter
        offersList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }

}