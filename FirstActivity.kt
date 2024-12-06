import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class FirstActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    var getName: ActivityResultLauncher<Intent> = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        res: ActivityResult ->
        if (res.resultCode == RESULT_OK) {
            res.data?.let {
                findViewById<TextView>(R.id.textView).text = "Привет, " + it.getStringExtra("name") + "!"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        findViewById<View>(R.id.mainButton).setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            getName.launch(intent)
        }
    }
}