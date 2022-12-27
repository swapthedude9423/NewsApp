package com.lastmile.wanicity

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lastmile.wanicity.data.model.News
import com.lastmile.wanicity.data.model.User
import com.lastmile.wanicity.databinding.ActivityMainBinding
import com.lastmile.wanicity.ui.main.adapter.NewsAdapter
import com.lastmile.wanicity.ui.main.viewmodel.MainViewModel
import com.lastmile.wanicity.utils.Status
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel : MainViewModel by viewModel()
    lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        setupObserver()
    }

    private fun setupObserver() {
        mainViewModel.news.observe(this, Observer {
            when(it.status){
                Status.LOADING ->{
                    progress.visibility= View.VISIBLE
                    newsList.visibility = View.GONE
                }
                Status.ERROR ->{
                    progress.visibility = View.GONE
                    newsList.visibility = View.VISIBLE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
                Status.SUCCESS -> {
                    progress.visibility = View.GONE
                    newsList.visibility = View.VISIBLE
                    it.data?.let {
                        news -> renderList(news.articles)
                    }
                }
            }
        })
    }

    private fun setupUI() {
        //newsList.layoutManager = LinearLayoutManager(this)
        adapter = NewsAdapter(arrayListOf())
//        newsList.addItemDecoration(DividerItemDecoration(
//            newsList.context,(newsList.layoutManager as LinearLayoutManager).orientation
//        ))
        newsList.adapter = this.adapter
    }

    private fun renderList(news:List<News>){
        adapter.addData(news)
        adapter.notifyItemRangeChanged(0,news.size)
    }


}
