package iniris.com.numaricalanalysis.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import iniris.com.numaricalanalysis.R;
import iniris.com.numaricalanalysis.calculations.Newton;

import com.google.android.gms.plus.PlusOneButton;
import iniris.com.numaricalanalysis.calculations.SecantMethod;
/**
 * A fragment with a Google +1 button.
 */
public class Secant extends Fragment {

    String result="";
    // The request code must be 0 or greater.
    private static final int PLUS_ONE_REQUEST_CODE = 0;
    // The URL to +1.  Must be a valid URL.
    private final String PLUS_ONE_URL = "http://developer.android.com";
    private PlusOneButton mPlusOneButton;
    TextView txt_result;
    EditText txt_fx,txt_point,txt_point1;

    Button btn_calc;

    public Secant() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_secant, container, false);

        txt_result= (TextView) view.findViewById(R.id.textResult3);
        btn_calc=(Button)view.findViewById(R.id.btnCalc3);
        txt_fx=(EditText) view.findViewById(R.id.txtfx3);
        txt_point=(EditText) view.findViewById(R.id.txtpoint3);
        txt_point1=(EditText) view.findViewById(R.id.txtpoint23);
        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Editable f = txt_fx.getText();
                    Editable point = txt_point.getText();
                    Editable point1 = txt_point1.getText();

                    //double x =Newton.Calculate("+1cos(+1x^+1)-1x^+1","-1sin(+1x^+1)-1x^+0",Math.PI/4);
                    double x = SecantMethod.Calculate(f.toString(),Double.parseDouble(point.toString().trim()),Double.parseDouble(point1.toString().trim()));
                    txt_point.setText(point1.toString());
                    txt_point1.setText(x+"");
                    result+=x+"\n";
                    txt_result.setText(result);

                }catch (Exception e ){
                    txt_result.setText(e.getMessage());
                    e.printStackTrace();
                }

            }
        });


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Refresh the state of the +1 button each time the activity receives focus.
    }


}
