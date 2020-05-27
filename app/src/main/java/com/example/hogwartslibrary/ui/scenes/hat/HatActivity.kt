package com.example.hogwartslibrary.ui.scenes.hat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.ViewManager
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.hogwartslibrary.R
import com.example.hogwartslibrary.helpers.Keys
import com.example.hogwartslibrary.ui.scenes.main.MainActivity
import kotlinx.android.synthetic.main.activity_hat.*

@Suppress("DEPRECATION")
class HatActivity : AppCompatActivity() {

    private lateinit var hatViewModel: HatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hat)

        hatViewModel = ViewModelProviders.of(this).get(HatViewModel::class.java)

        textWelcomeUsername.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                hatViewModel.applyUsername(name = s.toString())
            }
        })

        btnWelcomeSelect.setOnClickListener {
            if (btnWelcomeSelect.text == getString(R.string.welcome_next)) {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                hatViewModel.getFacultyName()
            }
        }

        setupFaculty(viewModel = hatViewModel)
        setupLoading(viewModel = hatViewModel)
    }

    private fun setupFaculty(viewModel: HatViewModel) {
        viewModel.facultyName.observe(this, Observer { facultyName ->
            if (facultyName.isNotEmpty()) {
                val sharedPreferences = getSharedPreferences(getString(R.string.app_name), 0)
                sharedPreferences.edit().putString(Keys.Username.value, textWelcomeUsername.text.toString())
                    .putString(Keys.Faculty.value, facultyName)
                    .apply()
                txtWelcomeSelected.text =
                    getString(R.string.welcome_selected).replace("[faculty_name]", facultyName)
                txtWelcomeSelected.visibility = View.VISIBLE
                textWelcomeUsername.isEnabled = false
                btnWelcomeSelect.text = getString(R.string.welcome_next)
            }
        })
    }

    private fun setupLoading(viewModel: HatViewModel) {
        viewModel.isLoading.observe(this, Observer { isLoading ->
            textWelcomeUsername.isEnabled = !isLoading
            btnWelcomeSelect.isEnabled = !isLoading
            if (isLoading)
                btnWelcomeSelect.text = getString(R.string.welcome_selecting)
        })
    }
}
