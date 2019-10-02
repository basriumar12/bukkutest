package com.example.mybukku.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.example.mybukku.R
import com.valdesekamdem.library.mdtoast.MDToast
import kotlin.system.exitProcess

open class BaseActivity : AppCompatActivity() {


    lateinit var loading: MaterialDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val materialDialog = MaterialDialog.Builder(this)
        materialDialog.progress(true, 0)
        materialDialog.cancelable(false)
        loading = materialDialog.build()

    }

    fun intentTo(target: Class<*>) {
        startActivity(Intent(this, target))
    }

    fun showErrorMessage(message: String?) {
        MDToast.makeText(this, message, MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
    }

    fun showSuccessMessage(message: String?) {
        MDToast.makeText(this, message, MDToast.LENGTH_SHORT, MDToast.TYPE_SUCCESS).show()
    }

    fun showInfoMessage(message: String?) {
        MDToast.makeText(this, message, MDToast.LENGTH_SHORT, MDToast.TYPE_INFO).show()
    }

    fun showLongErrorMessage(message: String?) {
        MDToast.makeText(this, message, MDToast.LENGTH_LONG, MDToast.TYPE_ERROR).show()
    }

    fun showLongSuccessMessage(message: String?) {
        MDToast.makeText(this, message, MDToast.LENGTH_LONG, MDToast.TYPE_SUCCESS).show()
    }

    fun showLongInfoMessage(message: String?) {
        MDToast.makeText(this, message, MDToast.LENGTH_LONG, MDToast.TYPE_INFO).show()
    }

    fun showProgressDialog() {
        loading.setContent(R.string.progress_dialog)
        loading.show()
    }
    fun showProgressDialog(message: String?) {
        loading.setContent(message)
        loading.show()
    }

    fun updateMessageDialog(message: String?) {
        loading.setContent(message)
    }

    fun dismissProgressDialog() {
        if (loading.isShowing)
            loading.dismiss()
    }


    



}


object DateUtils {
    const val DATE_FORMAT_YYYY = "yyyy-MM-dd"
    const val DATE_FORMAT_FULL = "EEEE dd MMM yyyy"
    const val DATE_FORMAT_HISTORY = "dd MMMM yyyy"

    fun formatStringToDate(date: String, format: String) : Date{
        val sdf = SimpleDateFormat(format, Locale.getDefault())
        return sdf.parse(date)
    }

    fun formatDateLong(date: Long, destinationFormat: String) : String{
        val sdfDest = SimpleDateFormat(destinationFormat, Locale.getDefault())
        return sdfDest.format(Date(date))
    }

    fun formatDateLongLocale(date: Long, destinationFormat: String) : String{
        val sdfDest = SimpleDateFormat(destinationFormat, Locale("in","ID"))
        return sdfDest.format(Date(date))
    }
    fun formatDateLocale(date: Date, destinationFormat: String) : String{
        val sdfDest = SimpleDateFormat(destinationFormat, Locale("in","ID"))
        return sdfDest.format(date)
    }

}
