package com.example.sopthactaton.presentation.ranking

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.OneShotPreDrawListener
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sopthactaton.api.ServicePool
import com.example.sopthactaton.databinding.ActivityRankingBinding
import com.example.sopthactaton.model.ResponseUsersRankingDto
import com.example.sopthactaton.presentation.accuse.AccuseActivity
import com.example.sopthactaton.presentation.home.TestViewModel
import com.example.sopthactaton.presentation.main.MainActivity
import com.example.sopthactaton.util.ViewModelFactory
import retrofit2.Call
import retrofit2.Response

class RankingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRankingBinding
    private val viewModel: TestViewModel by viewModels { ViewModelFactory(this) }

    private var one:Int? = null
    private var two:Int?= null
    private var three:Int? = null
    private var four:Int?= null
    private var five:Int? = null

    private var result = 0

    private lateinit var itemList:List<ResponseUsersRankingDto.Data.User>

    //private var getRankService = ServicePool.rankService
    override fun onCreate(savedInstanceState: Bundle?) {




        super.onCreate(savedInstanceState)
        binding = ActivityRankingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getUsersContent()
        viewModel.test.observe(this){
            Log.d("test",it.toString())
            result = it.user[0].life+it.user[1].life+it.user[2].life+it.user[3].life+it.user[4].life
            one = it.user[0].life
            two = it.user[1].life
            three = it.user[2].life
            four = it.user[3].life
            five = it.user[4].life
            itemList = listOf<ResponseUsersRankingDto.Data.User>(it.user[0],it.user[1],it.user[2],it.user[3],it.user[4])

            if(result==25){
                initAdapter(itemList,1)
            }
            else{
                initAdapter(itemList,2)
            }

        }






        clickToolbarBtnBack()
    }

    fun initAdapter(itemList: List<ResponseUsersRankingDto.Data.User>?,type:Int) {

        if(type==1){
            val noRankingAdapter = NoRankingAdapter()
            val topAdapter = TopTitleAdapter(1)
            noRankingAdapter.submitList(itemList)
            val concatAdapter = ConcatAdapter(topAdapter, noRankingAdapter)
            with(binding.rv) {
                adapter = concatAdapter
                layoutManager = LinearLayoutManager(context)
                noRankingAdapter.setOnItemClickListener(object : NoRankingAdapter.OnItemClickListener {
                    override fun onItemClick(v: View, data: ResponseUsersRankingDto.Data.User, pos: Int) {
                        Intent(this@RankingActivity, AccuseActivity::class.java).apply {
                            putExtra("data", data.nickname)
                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        }.run { startActivity(this) }
                    }

                })
            }
        }
        else{
            val rankingAdapter = RankingAdapter()
            val topAdapter = TopTitleAdapter(2)
            rankingAdapter.submitList(itemList)
            val concatAdapter = ConcatAdapter(topAdapter, rankingAdapter)
            with(binding.rv) {
                adapter = concatAdapter
                layoutManager = LinearLayoutManager(context)
                rankingAdapter.setOnItemClickListener(object : RankingAdapter.OnItemClickListener {
                    override fun onItemClick(v: View, data: ResponseUsersRankingDto.Data.User, pos: Int) {
                        Intent(this@RankingActivity, AccuseActivity::class.java).apply {
                            putExtra("data", data.nickname)
                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        }.run { startActivity(this) }
                    }

                })
            }
        }








    }



    private fun clickToolbarBtnBack() {
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }


}
