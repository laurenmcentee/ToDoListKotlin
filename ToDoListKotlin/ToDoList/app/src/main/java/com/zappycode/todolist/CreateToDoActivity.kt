package com.zappycode.todolist

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_to_do.*

class CreateToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_to_do)

        saveButton.setOnClickListener {
            var title = ""

            //if checkbox is checked put three
            //exclamations before title to note importance
            if (importantCheckBox.isChecked)
            {
                title = "!!! " + titleEditText.text.toString()
            } else
            {
                title = titleEditText.text.toString()
            }


            //gets list of shared preferences
            //mode is set to private (will not share with other apps)
            var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
            // gets current to do-list
            var todos = prefs.getStringSet(getString(R.string.TODO_STRINGS),setOf()).toMutableSet()
            //grabs text from titleEditText and puts into to-do list
            todos.add(title)

            ///putStringSet holds all existing items
            prefs.edit().putStringSet("todostrings",todos).apply()

            finish()
        }
    }
}
