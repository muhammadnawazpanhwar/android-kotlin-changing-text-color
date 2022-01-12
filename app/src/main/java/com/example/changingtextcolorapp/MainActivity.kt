package com.example.changingtextcolorapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {

    var fontFamily: String? = null
    var type: Typeface? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val message = findViewById<EditText>(R.id.message)
        val radiogroup = findViewById<RadioGroup>(R.id.radiogroup)
        val change = findViewById<Button>(R.id.change)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val selectedItem = resources.getStringArray(R.array.selectedItem)

            radiogroup.setOnCheckedChangeListener { group, checkedId ->
                if(checkedId==R.id.red){
                    textView.setTextColor(Color.parseColor(("#FF0000")))

                }
                else if(checkedId==R.id.green ) {
                    textView.setTextColor(Color.parseColor(("#00FF00")))

                }
                else if(checkedId== R.id.blue) {
                    textView.setTextColor(Color.parseColor("#0000FF"))

                }

        }

        if(spinner != null){
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, selectedItem)
            spinner.adapter = adapter

             spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                 override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                     change.setOnClickListener {
                         val input = message.text.toString()
                         textView.setText(input).toString()
                     fontFamily = parent.selectedItem.toString()
                     when (fontFamily) {
                         "Palette Mosaic" -> {
                             type = ResourcesCompat.getFont(baseContext, R.font.palettemosaic_regular)
                             textView.setTypeface(type)
                         }
                         "Qahiri" -> {
                             type = ResourcesCompat.getFont(baseContext, R.font.qahiri_regular)
                             textView.setTypeface(type)
                         }
                         "Style Script" -> {
                             type = ResourcesCompat.getFont(baseContext, R.font.stylescript_regular)
                             textView.setTypeface(type)
                         }
                         "Zen Tokyo Zoo" -> {
                             type = ResourcesCompat.getFont(baseContext, R.font.zentokyozoo_regular)
                             textView.setTypeface(type)
                         }
                     }
                     }
                 }
                    override fun onNothingSelected(parent: AdapterView<*>) {

                 }
             }
        }

    }
}