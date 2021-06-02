package br.nubank

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var configBtn : ImageButton
    lateinit var viewBtn : ImageButton
    lateinit var saldoTxt : EditText
    lateinit var faturaTxt : EditText
    lateinit var RS01_Txt : TextView
    lateinit var RS02_Txt : TextView
    lateinit var FirstLinear_01 : LinearLayout
    lateinit var FirstLinear_02 : LinearLayout
    lateinit var SecondLinear : LinearLayout
    lateinit var cartaoLayout : LinearLayout
    var IsEdit: Boolean = false
    var IsView: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configBtn = findViewById(R.id.configBtn)
        configBtn.setOnClickListener(this)

        viewBtn = findViewById(R.id.viewBtn)
        viewBtn.setOnClickListener(this)

        saldoTxt = findViewById(R.id.saldoTxt_02)
        faturaTxt = findViewById(R.id.faturaTxt_02)

        RS01_Txt = findViewById(R.id.saldoTxt_01)
        RS02_Txt = findViewById(R.id.faturaTxt_01)

        cartaoLayout = findViewById(R.id.cartaoLayout)

        FirstLinear_01 = findViewById(R.id.FirstLinear_01)
        FirstLinear_02 = findViewById(R.id.FirstLinear_02)
        SecondLinear = findViewById(R.id.SecondLinear)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.configBtn->{
                if (IsEdit) {
                    faturaTxt.setEnabled(false)
                    saldoTxt.setEnabled(false)
                    IsEdit = false
                }
                else {
                    faturaTxt.setEnabled(true)
                    saldoTxt.setEnabled(true)
                    IsEdit = true
                }
            }
            R.id.viewBtn->{
                if (IsView) {
                    FirstLinear_02.getLayoutParams().height = FirstLinear_02.getLayoutParams().height / 10
                    cartaoLayout.getLayoutParams().height = cartaoLayout.getLayoutParams().height * 9/10
                    SecondLinear.setBackgroundColor(Color.parseColor("#f5f5f5"))
                    FirstLinear_01.setBackgroundColor(Color.parseColor("#f5f5f5"))

                    FirstLinear_02.setVisibility(View.INVISIBLE)
                    RS01_Txt.setVisibility(View.INVISIBLE)
                    saldoTxt.setVisibility(View.INVISIBLE)
                    RS02_Txt.setVisibility(View.INVISIBLE)
                    faturaTxt.setVisibility(View.INVISIBLE)

                    viewBtn.setImageResource(R.mipmap.view_foreground)

                    IsView = false
                } else {
                    FirstLinear_02.getLayoutParams().height = FirstLinear_02.getLayoutParams().height * 10
                    cartaoLayout.getLayoutParams().height = cartaoLayout.getLayoutParams().height * 10/9
                    SecondLinear.setBackgroundColor(Color.parseColor("#00000000"))
                    FirstLinear_01.setBackgroundColor(Color.parseColor("#00000000"))
                    FirstLinear_02.setVisibility(View.VISIBLE)
                    RS01_Txt.setVisibility(View.VISIBLE)
                    saldoTxt.setVisibility(View.VISIBLE)
                    RS02_Txt.setVisibility(View.VISIBLE)
                    faturaTxt.setVisibility(View.VISIBLE)

                    viewBtn.setImageResource(R.mipmap.noview_foreground)

                    IsView = true
                }
                cartaoLayout.requestLayout();
            }
        }
    }
}