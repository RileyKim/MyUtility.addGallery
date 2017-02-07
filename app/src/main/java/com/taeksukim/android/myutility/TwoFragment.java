package com.taeksukim.android.myutility;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment implements View.OnClickListener{

    Button btnLength, btnArea, btnWeight;
    LinearLayout layoutLength, layoutArea, layoutWeight;
    TextView mm, cm, m, km, inch, ft, yd, mile;
    EditText num1;
    View view;


    public TwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_two, container, false);



        //1. 위젯 가져오기
        btnLength = (Button) view.findViewById(R.id.btnLength);
        btnArea = (Button) view.findViewById(R.id.btnArea);
        btnWeight = (Button) view.findViewById(R.id.btnWeight);

        btnLength.setOnClickListener(this);
        btnArea.setOnClickListener(this);
        btnWeight.setOnClickListener(this);

        layoutLength = (LinearLayout) view.findViewById(R.id.layoutLength);
        layoutArea = (LinearLayout) view.findViewById(R.id.layoutArea);
        layoutWeight = (LinearLayout) view.findViewById(R.id.layoutWeight);

        mm = (TextView) view.findViewById(R.id.textView1);
        cm = (TextView) view.findViewById(R.id.textView2);
        m = (TextView) view.findViewById(R.id.textView3);
        km = (TextView) view.findViewById(R.id.textView4);
        inch = (TextView) view.findViewById(R.id.textView5);
        ft = (TextView) view.findViewById(R.id.textView6);
        yd = (TextView) view.findViewById(R.id.textView7);
        mile = (TextView) view.findViewById(R.id.textView8);

        num1 = (EditText) view.findViewById(R.id.num1);

        num1.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;


    }

    @Override
    public void onClick(View view) {
        layoutLength.setVisibility(View.GONE);
        layoutArea.setVisibility(View.GONE);
        layoutWeight.setVisibility(View.GONE);
        switch(view.getId()) {
            case R.id.btnLength:
                layoutLength.setVisibility(View.VISIBLE);
                layoutArea.setVisibility(View.GONE);
                layoutWeight.setVisibility(View.GONE);
                break;

            case R.id.btnArea:
                layoutLength.setVisibility(View.GONE);
                layoutArea.setVisibility(View.VISIBLE);
                layoutWeight.setVisibility(View.GONE);
                break;

            case R.id.btnWeight:
                layoutLength.setVisibility(View.GONE);
                layoutArea.setVisibility(View.GONE);
                layoutWeight.setVisibility(View.VISIBLE);
                break;

        }
    }
}
