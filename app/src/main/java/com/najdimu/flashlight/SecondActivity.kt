package com.najdimu.flashlight

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.najdimu.flashlight.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding

    var flashSwitch = false
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.switchBtn.setOnClickListener {
            flashSwitch = !flashSwitch

            if (flashSwitch){

                val camManager = this.getSystemService(Context.CAMERA_SERVICE) as CameraManager
                camManager.setTorchMode(camManager.cameraIdList[0],true)

            }else{
                val camManager = this.getSystemService(Context.CAMERA_SERVICE) as CameraManager
                camManager.setTorchMode(camManager.cameraIdList[0],false)

            }
        }

    }
}