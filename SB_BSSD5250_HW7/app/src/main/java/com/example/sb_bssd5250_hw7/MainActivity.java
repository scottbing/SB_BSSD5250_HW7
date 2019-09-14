package com.example.sb_bssd5250_hw7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements NotesData.NotesDataUpdatedListener {

    private RecyclerView notesRV;
    private int i = 1;


    @Override
    public void updateNotesDependents() {
        NotesAdapter notesAdapter = new NotesAdapter();
        notesAdapter.setmContext(this);
        notesRV.swapAdapter(notesAdapter, true);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)	{
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        // setup an array of notes
        ArrayList<Note> notesArray = NotesData.getInstance(this).getNoteList();

        NotesData.getInstance(this).setListener(this);

        notesRV	= new RecyclerView(  this);
        notesRV.setBackgroundColor(Color.RED);

        NotesAdapter notesAdapter = new NotesAdapter();
        notesAdapter.setmContext(this);
        notesRV.setAdapter(notesAdapter);
        notesRV.setLayoutManager(new LinearLayoutManager( this));

        Button addNoteButton = new Button( this);
        addNoteButton.setText("+");
        addNoteButton.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,  ViewGroup.LayoutParams.WRAP_CONTENT));
        //make this button add a new note when clicked
        addNoteButton.setOnClickListener(addClickedListener);

        LinearLayout linearLayout = new LinearLayout( this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,  ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.addView(addNoteButton);
        linearLayout.addView(notesRV);

        setContentView(linearLayout);

    }

    private View.OnClickListener addClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d("addClick Listener", "add clicked");
            Note note = new Note();
            //note.setName("Note New");
            //note.setDesc("Desc New");
            note.setName("Note New " + String.valueOf(i));
            note.setDesc("Desc New " + String.valueOf(i++));
            NotesData.getInstance(MainActivity.this).getNoteList().add(note);
            NotesData.getInstance(null).refreshNotes();

        }
    };
}
