package com.app.externalstoageandroidkotlin

import android.Manifest
import android.content.ContentValues
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.example.externalstoragegalleryandcamerapicture.databinding.ActivityMainBinding
import java.io.File
import java.io.FileDescriptor
import java.io.FileOutputStream
import java.io.IOException


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var imageUri: Uri

    var galleryContract = registerForActivityResult(ActivityResultContracts.GetContent()){
        binding.ivThumbnail.setImageURI(null)
        if(it!=null){
            binding.ivThumbnail.setImageURI(it)

            uriToBitmap(it)?.let {
                saveImageToExternalStorage(it)
            }

        }
    }

    private val requestMultiplePermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            it.entries.forEach {
                Log.e("DEBUG", "${it.key} = ${it.value}")
            }
        }

    var cameraContract = registerForActivityResult(ActivityResultContracts.TakePicture()){
        binding.ivThumbnail.setImageURI(null)
        if(it){
            binding.ivThumbnail.setImageURI(imageUri)

            uriToBitmap(imageUri)?.let { it ->
                saveImageToExternalStorage(it)
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageUri = createImageUri()!!

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {

        } else {

            requestMultiplePermissions.launch(
                arrayOf(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
            )

        }


        binding.ivThumbnail.setOnClickListener {
            showOptionDialog()
        }

    }

    private fun saveImageToExternalStorage(bitmap: Bitmap) {

        val imageCollection = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)
            MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
        else
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.Q){

            // scope storage

            var resolver = contentResolver
            var contentValues = ContentValues()
            contentValues.put(
                MediaStore.MediaColumns.DISPLAY_NAME,
                "${System.currentTimeMillis()}.jpg"
            )
            contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
            contentValues.put(
                MediaStore.MediaColumns.RELATIVE_PATH,
                Environment.DIRECTORY_PICTURES + File.separator + "Tops Technologies"
            )

            var imageUri = resolver.insert(imageCollection, contentValues)

            if (imageUri != null) {
                contentResolver.openOutputStream(imageUri)?.let {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, it)
                    Toast.makeText(this, "Image Saved", Toast.LENGTH_SHORT).show()
                }
            }

        }else{
            val root = Environment.getExternalStorageDirectory()
            val path = File(root, "Tops Technologies")

            if (!path.exists()) {
                path.mkdir()
            }

            val file = File(path, "${System.currentTimeMillis()}.jpg")

            if (!file.exists()) {
                try {
                    val fos = FileOutputStream(file)
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
                    fos.flush()
                    fos.close()

                    Toast.makeText(this, "Image Saved", Toast.LENGTH_SHORT).show()

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

    }


    //TODO takes URI of the image and returns bitmap
    private fun uriToBitmap(selectedFileUri: Uri): Bitmap? {
        try {
            val parcelFileDescriptor = contentResolver.openFileDescriptor(selectedFileUri, "r")
            val fileDescriptor: FileDescriptor = parcelFileDescriptor!!.fileDescriptor
            val image = BitmapFactory.decodeFileDescriptor(fileDescriptor)
            parcelFileDescriptor.close()
            return image
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }

    private fun showOptionDialog() {
        var optionArray = arrayOf("From Gallery", "From Camera")

        AlertDialog.Builder(this)
            .setTitle("Pick Image")
            .setItems(optionArray, DialogInterface.OnClickListener { dialogInterface, i ->

                if(i==0){
                    // gallery
                    galleryContract.launch("image/*")
                }else if(i==1){
                    // camera
                    cameraContract.launch(imageUri)
                }

            }).show()

    }

    private fun createImageUri(): Uri? {
        val image = File(applicationContext.filesDir, "mypicture.png")
        return FileProvider.getUriForFile(
            applicationContext,
            "com.app.externalstoragegalleryandcamerapicture.fileProvider",
            image
        )
    }
}