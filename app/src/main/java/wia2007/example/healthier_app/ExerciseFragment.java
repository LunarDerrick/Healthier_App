package wia2007.example.healthier_app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExerciseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExerciseFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ExerciseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExerciseFragment.
     */
    public static ExerciseFragment newInstance(String param1, String param2) {
        ExerciseFragment fragment = new ExerciseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exercise, container, false);

        EditText ETTargetBurn = view.findViewById(R.id.ETTargetBurn);
        EditText ETEstiBurn = view.findViewById(R.id.ETEstiBurn);
        Button BtnCheck = view.findViewById(R.id.BtnCheck);

        // BtnCheck
        View.OnClickListener OCLCheck = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int targetValue = Integer.parseInt(ETTargetBurn.getText().toString());
                    int estimateValue = Integer.parseInt(ETEstiBurn.getText().toString());

                    if (targetValue > estimateValue) {
                        ETTargetBurn.setTextColor(ContextCompat.getColor(getActivity().getApplicationContext(), R.color.red));
                    } else {
                        ETTargetBurn.setTextColor(ContextCompat.getColor(getActivity().getApplicationContext(), R.color.text_green));
                    }
                } catch (NumberFormatException e) {
                    // if user haven't input anything
                    String message = "Please enter a value first!";
                    Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
                }
            }
        };
        BtnCheck.setOnClickListener(OCLCheck);

        return view;
    }
}