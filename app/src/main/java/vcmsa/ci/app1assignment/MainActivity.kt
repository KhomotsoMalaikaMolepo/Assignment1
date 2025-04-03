package vcmsa.ci.app1assignment

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
        //I have declared the variables
        val textViewSuggestion = findViewById<TextView>(R.id.textViewSuggestion)
        val editTextTime = findViewById<EditText>(R.id.editTextTime)
        val buttonSuggest = findViewById<Button>(R.id.buttonSuggest)
        val buttonReset = findViewById<Button>(R.id.buttonReset)
        //Author: Zahra Bulbulia
        //URL: https://github.com/zb662000/assignmen
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val rating = ratingBar.rating  //This variable is to make the code get the rating value
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        //Author: OpenaiChatGPT
        //URL: https://chatgpt.com/c/67ed7c10-9960-800c-9178-7fb280d06872


        //This button will show the meal suggestions as per the time of day when clicked by the user
        buttonSuggest.setOnClickListener {
            val timeOfDay = editTextTime.text.toString().trim()
            val suggestion = when (timeOfDay.lowercase()) {
                "morning" -> "Breakfast: Eggs, avocado and bacon on toast withe of watermelon bites and orange juice. YUMMY!"
                "mid-morning" -> "Brunch: Donut or caramel popcorn."
                "afternoon" -> "Lunch: Chicken caesar salad with some fries and a coke zero. MOUTH WATERING! "
                "mid-afternoon snack" -> "Light afternoon snack: Crisps and pineapple bites."
                "dinner" -> "Main course: Creamy salmon pasta and some orange juice. TASTES DIVINE!"
                "late night snack" -> "Dessert: Chocolate brownies with vanilla ice cream."
                else -> "Please enter valid time of day."
            }
            textViewSuggestion.text = suggestion

        }

        //This will reset the text view and the edit text box.
        //Author: Zahra Bulbulia
        //URL: https://github.com/zb662000/assignmen
        buttonReset.setOnClickListener {
            editTextTime.text.clear()
            textViewSuggestion.text = ""

        }
        //I added a rating bar and a text view for the rating result just for app features
        ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser -> }
        textViewResult.text = "Your rating: $rating stars"
        //Author: OpenaiChatGPT
        //URL: https://chatgpt.com/c/67ed7c10-9960-800c-9178-7fb280d06872


        //This code changes the suggest button color to light pink and the font to white
        buttonSuggest.backgroundTintList = ContextCompat.getColorStateList(this, R.color.light_pink)
        buttonSuggest.setTextColor(Color.WHITE)
        //Author: OpenaiChatGPT
        //URL: https://chatgpt.com/c/67ed7c10-9960-800c-9178-7fb280d06872


        //This code changes the reset button color to light pink and the font to white
        buttonReset.backgroundTintList = ContextCompat.getColorStateList(this, R.color.light_pink)
        buttonReset.setTextColor(Color.WHITE)
        //Author: OpenaiChatGPT
        //URL: https://chatgpt.com/c/67ed7c10-9960-800c-9178-7fb280d06872
    }
}