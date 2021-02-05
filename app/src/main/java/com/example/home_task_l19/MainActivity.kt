package com.example.home_task_l19

import android.app.ActivityOptions
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.util.toAndroidPair
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.home_task_l19.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var adapter = Adapter(this)

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupAdapter()
        setupData()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupAdapter() {
        val recyclerView = binding.rvListOfUsers
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.onItemClick = { user, view1, view2, view3 ->
            setupListener(user, view1, view2, view3)
        }
    }

    private fun setupData() {
        adapter.apply {
            addItemToList(
                UserInfo(
                    "Alexei",
                    "Troschij",
                    "Some text",
                    "https://i.kym-cdn.com/entries/icons/mobile/000/001/420/977.jpg"
                )
            )
            addItemToList(
                UserInfo(
                    "Elon",
                    "Musk",
                    "Some text",
                    "https://c.ndtvimg.com/2021-01/1ade279g_elon-musk-reuters_625x300_22_January_21.jpg"
                )
            )
            addItemToList(
                UserInfo(
                    "Ivan",
                    "Petrov",
                    "Some text",
                    "https://akm-img-a-in.tosshub.com/sites/btmt/images/stories/donald_trump_660_190520041254_080121100521.jpg"
                )
            )
            addItemToList(
                UserInfo(
                    "Petr",
                    "Ivanov",
                    "Some text",
                    "https://www.incimages.com/uploaded_files/image/1920x1080/GettyImages-1201476988_448569.jpg"
                )
            )
            addItemToList(
                UserInfo(
                    "Alexei",
                    "Troschij",
                    "Some text",
                    "https://i.kym-cdn.com/entries/icons/mobile/000/001/420/977.jpg"
                )
            )
            addItemToList(
                UserInfo(
                    "Elon",
                    "Musk",
                    "Some text",
                    "https://c.ndtvimg.com/2021-01/1ade279g_elon-musk-reuters_625x300_22_January_21.jpg"
                )
            )
        }
    }


    private fun setupListener(user: UserInfo, view1: View, view2: View, view3: View) {
        val pairImage = Pair<View, String>(
            view1,
            resources.getString(R.string.transition_image)
        ).toAndroidPair()
        val pairName = Pair<View, String>(
            view2,
            resources.getString(R.string.transition_title)
        ).toAndroidPair()
        val pairBody = Pair<View, String>(
            view3,
            resources.getString(R.string.transition_body)
        ).toAndroidPair()
        val activityOptions = ActivityOptions
            .makeSceneTransitionAnimation(this, pairImage, pairName, pairBody)
        SharedSecondActivity.start(this, user, activityOptions)
    }

}

