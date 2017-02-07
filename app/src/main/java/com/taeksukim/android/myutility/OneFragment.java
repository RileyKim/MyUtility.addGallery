package com.taeksukim.android.myutility;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment implements View.OnClickListener{

    View view;
    TextView result;
    TextView preview;
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;

    Button btnPlus;
    Button btnMinus;
    Button btnMultipy;
    Button btnDivide;

    Button btnRun;
    Button btnCancel;




    public OneFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //뷰를 재사용하기 위해 Holder형태로 만들어준다.
        if(view != null){
            return view;
        }

        view = inflater.inflate(R.layout.fragment_one, container, false);

        result = (TextView) view.findViewById(R.id.result);
        preview = (TextView) view.findViewById(R.id.preview);
        btn0 = (Button) view.findViewById(R.id.btn0);
        btn1 = (Button) view.findViewById(R.id.btn1);
        btn2 = (Button) view.findViewById(R.id.btn2);
        btn3 = (Button) view.findViewById(R.id.btn3);
        btn4 = (Button) view.findViewById(R.id.btn4);
        btn5 = (Button) view.findViewById(R.id.btn5);
        btn6 = (Button) view.findViewById(R.id.btn6);
        btn7 = (Button) view.findViewById(R.id.btn7);
        btn8 = (Button) view.findViewById(R.id.btn8);
        btn9 = (Button) view.findViewById(R.id.btn9);

        btnPlus = (Button) view.findViewById(R.id.plus);
        btnMinus = (Button) view.findViewById(R.id.minus);
        btnMultipy = (Button) view.findViewById(R.id.multiply);
        btnDivide = (Button) view.findViewById(R.id.divide);
        btnRun = (Button) view.findViewById(R.id.run);
        btnCancel = (Button) view.findViewById(R.id.cancle);


        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultipy.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnRun.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View view) {
        Log.d("CalculatorActivity","view="+view);

        switch(view.getId()){
            case R.id.btn0:
                addPreview("0");
                break;
            case R.id.btn1:
                addPreview("1");
                break;
            case R.id.btn2:
                addPreview("2");
                break;
            case R.id.btn3:
                addPreview("3");
                break;
            case R.id.btn4:
                addPreview("4");
                break;
            case R.id.btn5:
                addPreview("5");
                break;
            case R.id.btn6:
                addPreview("6");
                break;
            case R.id.btn7:
                addPreview("7");
                break;
            case R.id.btn8:
                addPreview("8");
                break;
            case R.id.btn9:
                addPreview("9");
                break;
            case R.id.plus:
                addPreview("+");
                break;
            case R.id.minus:
                addPreview("-");
                break;
            case R.id.multiply:
                addPreview("*");
                break;
            case R.id.divide:
                addPreview("/");
                break;
            case R.id.run:
                eval(preview.getText().toString());
                break;
            case R.id.cancle:
                Log.d("CalculatorActivity","cancel clicked="+view);
                setPreview("");
                setResult("");
                break;
        }
    }

    // 문자열을 수식으로 계산하기
    private void eval(String value){
        String r = "";

        // 1. 문자열을 정규식으로 * / + - 을 이용해서 배열로 자른다
        String splited[] = value.split("(?<=[*/+-])|(?=[*/+-])");

        // 2. 동적배열을 사용하기 위해 ArrayList 담는다.
        //    이유는 연산이 일어나는 값이 연산자를 기준으로 앞뒤로 존재하는데,
        //    연산후에 삭제하기 위해서 동적배열을 사용한다.
        ArrayList<String> list = new ArrayList<>();

        // 3. 처리 중간에 배열을 자유롭게 삭제하기 위해 담는다.
        for(String item : splited)
            list.add(item);

        int index = 0;

        // 4. 연산자 우선순위가 높은 * , / 를 먼저 처리한다.
        //    배열을 돌면서 연산자를 기준으로 값을 꺼낸다
        for( index=0 ; index < list.size() ;){
            // 4.1 item 변수에 값을 담은 후
            String item = list.get(index);

            double one = 0;
            double two = 0;
            double sum = 0;
            boolean check = true;
            // 4.2 값이 곱하기 일경우
            if(item.equals("*")) {
                // 4.2.1 연산자 앞의 숫자를 꺼내고
                one = Double.parseDouble(list.get(index-1));
                // 4.2.2 연산자 뒤의 숫자를 꺼낸다
                two = Double.parseDouble(list.get(index+1));
                // 4.3.3 두 숫자를 곱한다.
                sum = one * two;
                Log.d("CalculatorActivity","check [***] index="+index+", sum="+sum);
                // 곱하기에 걸렸다는 표식을 해준다
                check = true;
                // 4.3 값이 나누기일 경우
            }else if(item.equals("/")){
                // 4.3.1 연산자 앞의 숫자를 꺼내고
                one = Double.parseDouble(list.get(index-1));
                // 4.3.2 연산자 뒤의 숫자를 꺼낸다.
                two = Double.parseDouble(list.get(index+1));
                // 4.3.3 값을 더한다.
                sum = one / two;
                Log.d("CalculatorActivity","check [///] index="+index+", sum="+sum);
                check = true;
                // 4.4 연산자에 걸리지 않으면 체크 플래그를 false 전환해서 반복문을 진행하게 한다.
            }else{
                check = false;
            }

            // 4.5 앞에서 * 또는 / 에 걸리면
            if(check) {
                // 4.5.1 현재 내 연산자 위치에 결과값을 저장하고
                list.set(index, sum + "");
                // 4.5.2 이미 연산된 뒤의 값을 먼저 제거하고
                list.remove(index + 1);
                // 4.5.3 이미 연산된 앞의 값을 제거한다.
                list.remove(index - 1);
                // 4.6 앞에서 체크되지 않았으면 index 만 증가해서 다음 값을 비교한다.
            }else {
                index++;
            }
        }

        Log.d("CalculatorActivity","check [index]="+index);

        index = 0;

        // 5. + - 를 검사한다.
        for( index=0 ; index < list.size() ;){
            String item = list.get(index);
            double one = 0;
            double two = 0;
            double sum = 0;
            boolean check = true;
            if(item.equals("+")) {
                one = Double.parseDouble(list.get(index-1));
                two = Double.parseDouble(list.get(index+1));
                sum = one + two;
                Log.d("CalculatorActivity","check [+++] index="+index+", sum="+sum);
                check = true;
            }else if(item.equals("-")){
                one = Double.parseDouble(list.get(index-1));
                two = Double.parseDouble(list.get(index+1));
                sum = one - two;
                Log.d("CalculatorActivity","check [---] index="+index+", sum="+sum);
                check = true;
            }else{
                check = false;
            }

            if(check) {
                list.set(index, sum + "");
                list.remove(index + 1);
                list.remove(index - 1);
                index--;
            }else {
                index++;
            }
        }

        // 최종적으로 list 의 0번째 값을 꺼내면 결과를 확인할 수 있다.
        setResult("Result : "+list.get(0));
    }

    private void setResult(String string){
        result.setText(string);
    }

    private void addPreview(String string){
        setPreview(preview.getText() + string);
    }

    private void setPreview(String string){
        preview.setText(string);
    }

}
