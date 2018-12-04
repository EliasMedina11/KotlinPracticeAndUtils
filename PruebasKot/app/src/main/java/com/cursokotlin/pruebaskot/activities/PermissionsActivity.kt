package com.cursokotlin.pruebaskot.activities


import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Toast
import com.cursokotlin.pruebaskot.R
import kotlinx.android.synthetic.main.activity_permissions.*


class PermissionsActivity : AppCompatActivity() {

    private val requestCameraPermission = 100
    private val requestCameraPicture = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions)

        buttonPicture.setOnClickListener { getPictureFromCamera() }
    }

    private fun getPictureFromCamera() {
        //Asegurarnos de que no hay permiso de camara en el manifest
        //Crear intent para capturar la foto

        val pictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        // Comprobar que podemos manejar la captura de fotos (Tenemos camara y app de camara)
        if (pictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(pictureIntent , requestCameraPicture) // reutilizamos el mismo onActivityResult
        } else {
            // No hay activity que pueda manejar el intent (Por ejemplo sin camara)
        }
    }

    private fun getPictureFromCameraAskingPermissions () {
        //Añadir permiso al manifest
        //Comprobar el permiso
       if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
           //si no ha sido aceptado previamente API 23+
           ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),requestCameraPermission)
        } else {
           // si ha sido aceptado previamente en instalacion API 23-
           val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
           startActivityForResult(intent,requestCameraPicture)
       }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
      when (requestCode){
          requestCameraPermission -> {
              if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                  //permiso aceptado
                  val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                  startActivityForResult(intent,requestCameraPicture)
              } else {
                  //Permiso denegado
                  Toast.makeText(this,"You can't take a picture if you don't accept the permission",Toast.LENGTH_SHORT).show()
              }
          }
      }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode){
            requestCameraPicture -> {
                // Comprobar si el resultado es bueno
                if (resultCode == Activity.RESULT_OK) {
                    //Obtenemos los extras del intent recibido por parametros
                    val extras = data!!.extras
                    // Formamos el bitmap a partir de los extras
                    val imageBitMap = extras.get("data") as Bitmap
                    // Cargamos la foto como bitmap en el imageView
                    imageViewPicture.setImageBitmap(imageBitMap)
                } else {
                    // la foto no ha sido tomada con exito
                    Toast.makeText(this , "Picture has failed" , Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}
