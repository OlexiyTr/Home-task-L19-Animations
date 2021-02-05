package com.example.home_task_l19

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.bumptech.glide.Glide
import com.example.home_task_l19.databinding.UserProfileActivityBinding

class SharedSecondActivity : AppCompatActivity() {
    private lateinit var binding: UserProfileActivityBinding

    companion object {
        private const val EXTRA_USER = "EXTRA_USER"
        fun start(context: Context, user: UserInfo, options: ActivityOptions) {
            val intent = Intent(context, SharedSecondActivity::class.java)
            intent.putExtra(EXTRA_USER, user)
            startActivity(context, intent, options.toBundle())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupData()
    }

    private fun setupBinding() {
        binding = UserProfileActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupData() {
        val user = intent.getParcelableExtra<UserInfo>(EXTRA_USER)
        val title = "${user?.firstName} ${user?.secondName}"
        val linkImage = user?.imageUrl
        val body = user?.description
        binding.apply {
            tvTitle.text = title
            tvBody.text = body
        }
        Glide.with(this)
            .load(linkImage)
            .into(binding.ivProfile)
    }
}