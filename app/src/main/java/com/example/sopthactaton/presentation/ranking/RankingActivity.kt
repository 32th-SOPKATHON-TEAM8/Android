package com.example.sopthactaton.presentation.ranking


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sopthactaton.api.model.ResponseRankingDto
import com.example.sopthactaton.databinding.ActivityRankingBinding
import com.example.sopthactaton.presentation.accuse.AccuseActivity
import com.example.sopthactaton.presentation.home.TestViewModel
import com.example.sopthactaton.presentation.main.MainActivity
import com.example.sopthactaton.util.ViewModelFactory

class RankingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRankingBinding
    private val viewModel: TestViewModel by viewModels { ViewModelFactory(this) }

    private var one: Int? = null
    private var two: Int? = null
    private var three: Int? = null
    private var four: Int? = null
    private var five: Int? = null

    private var result = 0

    //private var getRankService = ServicePool.rankService
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityRankingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getUsersContent()
        viewModel.test.observe(this) {
            Log.d("test", it.toString())
            result =
                it.user[0].life + it.user[1].life + it.user[2].life + it.user[3].life + it.user[4].life
            one = it.user[0].life
            two = it.user[1].life
            three = it.user[2].life
            four = it.user[3].life
            five = it.user[4].life

        }


        val itemList = listOf<ResponseRankingDto.Data>(
            ResponseRankingDto.Data(200, "그룹 상세 조회 성공", 4, true),
            ResponseRankingDto.Data(200, "그룹 상세 조회 성공", 5, true),
            ResponseRankingDto.Data(200, "그룹 상세 조회 성공", 5, true),
            ResponseRankingDto.Data(200, "그룹 상세 조회 성공", 5, true)
        )

        if (result == 25) {
            initAdapter(itemList, 1)
        } else {
            initAdapter(itemList, 2)
        }
        clickToolbarBtnBack()
    }

    fun initAdapter(itemList: List<ResponseRankingDto.Data>?, type: Int) {


        val rankingAdapter = RankingAdapter()
        val topAdapter = TopTitleAdapter(1)
        rankingAdapter.submitList(itemList)
        val concatAdapter = ConcatAdapter(topAdapter, rankingAdapter)

        with(binding.rv) {
            adapter = concatAdapter
            layoutManager = LinearLayoutManager(context)
        }

        rankingAdapter.setOnItemClickListener(object : RankingAdapter.OnItemClickListener {
            override fun onItemClick(v: View, data: ResponseRankingDto.Data, pos: Int) {
                Intent(this@RankingActivity, AccuseActivity::class.java).apply {
                    putExtra("data", data.nickname)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { startActivity(this) }
            }

        })


    }


    private fun clickToolbarBtnBack() {
        binding.toolbar.setNavigationOnClickListener {
            startActivity(Intent(this, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            })
        }
//        setSupportActionBar(binding.toolbar)
//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
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
