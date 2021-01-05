package com.hanseungheon.recoder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hanseungheon.recoder.databinding.ActivityFilelistBinding

class FilelistActivity : AppCompatActivity() {

    lateinit var binding: ActivityFilelistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_filelist)
        binding.activity = this

        val list = mutableListOf(
            Record("파일이름1.mp3", 180),
            Record("파일이름2.mp3", 10),
            Record("파일이름3.mp3", 77)
        )

        binding.recyclerView.adapter = FileAdapter(list)
    }
}