package wia2007.example.healthier_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FastingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FastingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public int counter;
    public int pauseCounter;
    public CountDownTimer countDownTimer;

    public FastingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FastingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FastingFragment newInstance(String param1, String param2) {
        FastingFragment fragment = new FastingFragment();
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
        View view = inflater.inflate(R.layout.fragment_fasting, container, false);

        Button BtnStart = view.findViewById(R.id.BtnStart);
        Button BtnPause = view.findViewById(R.id.BtnPause);
        Button BtnResume = view.findViewById(R.id.BtnResume);
        Button BtnEnd = view.findViewById(R.id.BtnEnd);
        TextView TVTimeCountDown = view.findViewById(R.id.TVTimeCountDown);
        EditText ETDurationFast = view.findViewById(R.id.ETDurationFast);
        ProgressBar progressBar = view.findViewById(R.id.PBProgressFast);

        BtnPause.setVisibility(view.GONE);
        BtnResume.setVisibility(view.GONE);

        BtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String durationStr = ETDurationFast.getText().toString();
                counter = Integer.parseInt(durationStr);
                progressBar.setProgress(0);
                progressBar.setMax(counter+1);

                countDownTimer = new CountDownTimer(counter * 1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        TVTimeCountDown.setText(String.valueOf(counter));
                        counter--;
                        progressBar.incrementProgressBy(1);
                    }

                    public void onFinish() {
                        TVTimeCountDown.setText("COMPLETE");
                        progressBar.incrementProgressBy(1);

                        BtnPause.setVisibility(view.GONE);
                        BtnResume.setVisibility(view.GONE);
                        BtnStart.setVisibility(view.VISIBLE);

                        String message = "Time's Up";
                        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    }
                }.start();

                BtnStart.setVisibility(view.GONE);
                BtnPause.setVisibility(view.VISIBLE);
            }
        });

        BtnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseCounter = counter+1;
                countDownTimer.cancel();

                BtnPause.setVisibility(view.GONE);
                BtnResume.setVisibility(view.VISIBLE);

                String message = "Timer paused";
                Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });

        BtnResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setProgress(Integer.parseInt(ETDurationFast.getText().toString()) - pauseCounter + 1);

                countDownTimer = new CountDownTimer(counter * 1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        TVTimeCountDown.setText(String.valueOf(counter));
                        counter--;
                        progressBar.incrementProgressBy(1);
                    }

                    public void onFinish() {
                        TVTimeCountDown.setText("COMPLETE");
                        progressBar.incrementProgressBy(1);

                        BtnPause.setVisibility(view.GONE);
                        BtnResume.setVisibility(view.GONE);
                        BtnStart.setVisibility(view.VISIBLE);

                        String message = "Time's Up";
                        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    }
                }.start();

                BtnResume.setVisibility(view.GONE);
                BtnPause.setVisibility(view.VISIBLE);
            }
        });

        BtnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();

                String durationStr = ETDurationFast.getText().toString();
                counter = Integer.parseInt(durationStr);
                TVTimeCountDown.setText(String.valueOf(counter));
                progressBar.setProgress(0);

                BtnPause.setVisibility(view.GONE);
                BtnResume.setVisibility(view.GONE);
                BtnStart.setVisibility(view.VISIBLE);

                String message = "Timer cancelled";
                Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fasting, container, false);
        return view;
    }
}