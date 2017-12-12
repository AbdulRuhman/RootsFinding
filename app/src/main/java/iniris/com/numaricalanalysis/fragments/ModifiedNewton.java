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
import iniris.com.numaricalanalysis.calculations.NewtonModified;

import com.google.android.gms.plus.PlusOneButton;

/**
 * A fragment with a Google +1 button.
 */
public class ModifiedNewton extends Fragment {

    // The request code must be 0 or greater.
    private static final int PLUS_ONE_REQUEST_CODE = 0;
    // The URL to +1.  Must be a valid URL.
    private final String PLUS_ONE_URL = "http://developer.android.com";
    private PlusOneButton mPlusOneButton;
    String result="";

    TextView txt_result;
    EditText txt_fx,txt_dx,txt_ddx,txt_point;

    Button btn_calc;

    public ModifiedNewton() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_modified_newton, container, false);

        txt_result= (TextView) view.findViewById(R.id.textResult2);
        btn_calc=(Button)view.findViewById(R.id.btnCalc2);
        txt_dx=(EditText) view.findViewById(R.id.txtdx2);
        txt_ddx=(EditText) view.findViewById(R.id.txtddfx2);
        txt_fx=(EditText) view.findViewById(R.id.txtfx2);
        txt_point=(EditText) view.findViewById(R.id.txtpoint2);
        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{

                    //double x =Newton.Calculate("+1cos(+1x^+1)-1x^+1","-1sin(+1x^+1)-1x^+0",Math.PI/4);
                    Editable fx=txt_fx.getText();
                    Editable dfx=txt_dx.getText();
                    Editable ddfx=txt_ddx.getText();
                    Editable point=txt_point.getText();
                  double x = NewtonModified.Calculate(fx.toString(),dfx.toString(),ddfx.toString(),Double.parseDouble(point.toString().trim()));
                    txt_point.setText(x+"");
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
