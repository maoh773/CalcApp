package jp.techacademy.kimura.hirohisa.calcapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonAddition.setOnClickListener(this)
        buttonSubtraction.setOnClickListener(this)
        buttonMultiplication.setOnClickListener(this)
        buttonDivision.setOnClickListener(this)

    }

    override fun onClick(v: View) {

        if (editText_1.text.isEmpty() || editText_2.text.isEmpty()) {
            Snackbar.make(v, "数値を入力してください", Snackbar.LENGTH_SHORT).show()
            return
        }

        val element_1 = editText_1.text.toString().toFloat()
        val element_2 = editText_2.text.toString().toFloat()

        var calcResult: Float = 0.0f
        when (v.id) {
            R.id.buttonAddition -> calcResult = element_1 + element_2
            R.id.buttonSubtraction -> calcResult = element_1 - element_2
            R.id.buttonMultiplication -> calcResult = element_1 * element_2
            R.id.buttonDivision -> {
                if (element_2 == 0.0f) {
                    Snackbar.make(v, "0では割れません", Snackbar.LENGTH_SHORT).show()
                    return
                }
                calcResult = element_1 / element_2
            }
        }

        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("Result", calcResult)

        startActivity(intent)
    }

}
