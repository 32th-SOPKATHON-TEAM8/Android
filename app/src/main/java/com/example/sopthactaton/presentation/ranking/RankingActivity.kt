package com.example.sopthactaton.presentation.ranking

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sopthactaton.api.ServicePool
import com.example.sopthactaton.api.model.ResponseRankingDto
import com.example.sopthactaton.databinding.ActivityRankingBinding
import com.example.sopthactaton.presentation.main.MainActivity
import retrofit2.Call
import retrofit2.Response

class RankingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRankingBinding

    private var getRankService = ServicePool.rankService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRankingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val itemList = listOf<ResponseRankingDto.Data>(
            ResponseRankingDto.Data(200, "그룹 상세 조회 성공", 4, true),
            ResponseRankingDto.Data(200, "그룹 상세 조회 성공", 5, true),
            ResponseRankingDto.Data(200, "그룹 상세 조회 성공", 5, true),
            ResponseRankingDto.Data(200,"그룹 상세 조회 성공",5,true)
        )
        initAdapter(itemList)
        clickToolbarBtnBack()
    }

    fun initAdapter(itemList: List<ResponseRankingDto.Data>?) {

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
                Intent(this@RankingActivity, Test2Activity::class.java).apply {
                    putExtra("data", data.nickname)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { startActivity(this) }
            }

        })


    }

    private fun getRanking() {
        getRankService.rank().enqueue(
            object : retrofit2.Callback<ResponseRankingDto> {
                override fun onResponse(
                    call: Call<ResponseRankingDto>,
                    response: Response<ResponseRankingDto>
                ) {
                    if (response.isSuccessful) {
                        val userList = response.body()?.data
                        initAdapter(userList)

                    }

                }

                override fun onFailure(call: Call<ResponseRankingDto>, t: Throwable) {
                    Toast.makeText(this@RankingActivity, "서버 실패", Toast.LENGTH_SHORT).show()
                }
            }
        )
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
