package jp.techacademy.kimura.hirohisa.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout.*
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val result = intent.getFloatExtra("Result", 0.0f)

        val textView = TextView(this)
        textView.text = result.toString()
        textView.textSize = 20 * resources.displayMetrics.density
        textView.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        textView.gravity = Gravity.CENTER

        setContentView(textView)

    }
}
