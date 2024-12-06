import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        findViewById<Button>(R.id.secondButton).setOnClickListener {
            val intent = Intent()
            intent.putExtra("name", findViewById<EditText>(R.id.editTextText).text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}