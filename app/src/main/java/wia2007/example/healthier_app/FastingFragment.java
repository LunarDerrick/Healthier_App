package wia2007.example.healthier_app;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FastingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FastingFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public int counter, pauseCounter, initialCounter, durationHr, durationMin, durationSec, displayHr, displayMin, displaySec;
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
        Button BtnEditStart = view.findViewById(R.id.BtnEditStart);
        Button BtnDoneEdit = view.findViewById(R.id.BtnDoneEdit);
        Button Btn52Diet = view.findViewById(R.id.Btn52Diet);
        Button BtnEatStop = view.findViewById(R.id.BtnEatStop);
        Button Btn168Method = view.findViewById(R.id.Btn168Method);
        TextView TVTimeCountDown = view.findViewById(R.id.TVTimeCountDown);
        TextView TVTimeStart = view.findViewById(R.id.TVTimeStart);
        TextView TVTimeEnd = view.findViewById(R.id.TVTimeEnd);
        TextView TVTimeEnd2 = view.findViewById(R.id.TVTimeEnd2);
        EditText ETDurationFastHr = view.findViewById(R.id.ETDurationFastHr);
        EditText ETDurationFastMin = view.findViewById(R.id.ETDurationFastMin);
        EditText ETDurationFastSec = view.findViewById(R.id.ETDurationFastSec);
        EditText ETTimeStart = view.findViewById(R.id.ETTimeStart);
        ProgressBar progressBar = view.findViewById(R.id.PBProgressFast);
        TableRow TRStatusFast2 = view.findViewById(R.id.TRStatusFast2);
        TableRow TRStatusFast3 = view.findViewById(R.id.TRStatusFast3);
        TableRow TRStatusFast4 = view.findViewById(R.id.TRStatusFast4);
        TableRow TRStatusFast5 = view.findViewById(R.id.TRStatusFast5);
        final LayoutInflater[] inflater1 = {inflater};

        BtnPause.setVisibility(View.GONE);
        BtnResume.setVisibility(View.GONE);
        TRStatusFast4.setVisibility(View.GONE);
        TRStatusFast5.setVisibility(View.GONE);

        BtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Retrieve user input
                    String durationHrStr = ETDurationFastHr.getText().toString();
                    String durationMinStr = ETDurationFastMin.getText().toString();
                    String durationSecStr = ETDurationFastSec.getText().toString();
                    String timeStart = TVTimeStart.getText().toString();

                    durationHr = Integer.parseInt(durationHrStr);
                    durationMin = Integer.parseInt(durationMinStr);
                    durationSec = Integer.parseInt(durationSecStr);

                    // Cancel action if input out of range
                    if (durationHr < 0 || durationHr > 23) {
                        throw new Exception("Hour out of range");
                    }

                    if (durationMin < 0 || durationMin > 59) {
                        throw new Exception("Minute out of range");
                    }

                    if (durationSec < 0 || durationSec > 59) {
                        throw new Exception("Second out of range");
                    }

                    // Edit start-end table
                    String[] time = timeStart.split(":");
                    int timeStartHr = Integer.parseInt(time[0]);
                    int timeStartMin = Integer.parseInt(time[1]);
                    int timeEndHr = timeStartHr + durationHr;
                    int timeEndMin = timeStartMin + durationMin;

                    if (timeEndMin >= 60) {
                        timeEndMin -= 60;
                        timeEndHr++;
                    }
                    if (timeEndHr >= 24) {
                        timeEndHr -= 24;
                    }

                    String TimeEndNew = String.format("%02d:%02d", timeEndHr, timeEndMin);
                    TVTimeEnd.setText(TimeEndNew);
                    TVTimeEnd2.setText(TimeEndNew);

                    // Implementation
                    counter = 0; // reset in case of resume button
                    pauseCounter = 0; // reset in case of resume button
                    counter += durationHr * 3600;
                    counter += durationMin * 60;
                    counter += durationSec;
                    initialCounter = counter;

                    progressBar.setProgress(0);
                    progressBar.setMax(counter + 1);

                    displayHr = durationHr;
                    displayMin = durationMin;
                    displaySec = durationSec;

                    countDownTimer = new CountDownTimer(counter * 1000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            TVTimeCountDown.setText(String.format("%02d:%02d:%02d", displayHr, displayMin, displaySec));
                            counter--;
                            if (displaySec == 0) {
                                displaySec = 59;
                                if (displayMin == 0) {
                                    displayMin = 59;
                                    displayHr--;
                                } else {
                                    displayMin--;
                                }
                            } else {
                                displaySec--;
                            }
                            progressBar.incrementProgressBy(1);
                        }

                        public void onFinish() {
                            TVTimeCountDown.setText("COMPLETE");
                            progressBar.incrementProgressBy(1);

                            BtnPause.setVisibility(View.GONE);
                            BtnResume.setVisibility(View.GONE);
                            BtnStart.setVisibility(View.VISIBLE);

                            String message = "Time's Up";
                            Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
                        }
                    }.start();

                    BtnStart.setVisibility(View.GONE);
                    BtnPause.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
                }
            }
        });

        BtnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseCounter = counter + 1;
                countDownTimer.cancel();

                BtnPause.setVisibility(View.GONE);
                BtnResume.setVisibility(View.VISIBLE);

                String message = "Timer paused";
                Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });

        BtnResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setProgress(initialCounter - pauseCounter + 1);

                countDownTimer = new CountDownTimer(counter * 1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        TVTimeCountDown.setText(String.format("%02d:%02d:%02d", displayHr, displayMin, displaySec));
                        counter--;
                        if (displaySec == 0) {
                            displaySec = 59;
                            if (displayMin == 0) {
                                displayMin = 59;
                                displayHr--;
                            } else {
                                displayMin--;
                            }
                        } else {
                            displaySec--;
                        }
                        progressBar.incrementProgressBy(1);
                    }

                    public void onFinish() {
                        TVTimeCountDown.setText("COMPLETE");
                        progressBar.incrementProgressBy(1);

                        BtnPause.setVisibility(View.GONE);
                        BtnResume.setVisibility(View.GONE);
                        BtnStart.setVisibility(View.VISIBLE);

                        String message = "Time's Up";
                        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    }
                }.start();

                BtnResume.setVisibility(View.GONE);
                BtnPause.setVisibility(View.VISIBLE);
            }
        });

        BtnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();

                String durationHrStr = ETDurationFastHr.getText().toString();
                String durationMinStr = ETDurationFastMin.getText().toString();
                String durationSecStr = ETDurationFastSec.getText().toString();

                durationHr = Integer.parseInt(durationHrStr);
                durationMin = Integer.parseInt(durationMinStr);
                durationSec = Integer.parseInt(durationSecStr);

                displayHr = durationHr;
                displayMin = durationMin;
                displaySec = durationSec;

                TVTimeCountDown.setText(String.format("%02d:%02d:%02d", displayHr, displayMin, displaySec));
                progressBar.setProgress(0);

                BtnPause.setVisibility(View.GONE);
                BtnResume.setVisibility(View.GONE);
                BtnStart.setVisibility(View.VISIBLE);

                String message = "Timer cancelled";
                Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });

        BtnEditStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TRStatusFast2.setVisibility(View.GONE);
                TRStatusFast3.setVisibility(View.GONE);
                TRStatusFast4.setVisibility(View.VISIBLE);
                TRStatusFast5.setVisibility(View.VISIBLE);

                String message = "Enter Edit Mode";
                Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });

        BtnDoneEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TRStatusFast2.setVisibility(View.VISIBLE);
                TRStatusFast3.setVisibility(View.VISIBLE);
                TRStatusFast4.setVisibility(View.GONE);
                TRStatusFast5.setVisibility(View.GONE);

                TVTimeStart.setText(ETTimeStart.getText().toString());

                String message = "Exit Edit Mode";
                Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });

        Btn52Diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflater1[0] = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater1[0].inflate(R.layout.popup_52diet, null);

                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                // show the popup window
                // which view you pass in doesn't matter, it is only used for the window tolken
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

                // dismiss the popup window when touched
                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        return true;
                    }
                });

                ETDurationFastHr.setText("23");
                ETDurationFastMin.setText("59");
                ETDurationFastSec.setText("59");
            }
        });

        BtnEatStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflater1[0] = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater1[0].inflate(R.layout.popup_eatstop, null);

                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                // show the popup window
                // which view you pass in doesn't matter, it is only used for the window tolken
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

                // dismiss the popup window when touched
                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        return true;
                    }
                });

                ETDurationFastHr.setText("23");
                ETDurationFastMin.setText("59");
                ETDurationFastSec.setText("59");
            }
        });

        Btn168Method.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflater1[0] = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater1[0].inflate(R.layout.popup_168method, null);

                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                // show the popup window
                // which view you pass in doesn't matter, it is only used for the window tolken
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

                // dismiss the popup window when touched
                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        return true;
                    }
                });

                ETDurationFastHr.setText("16");
                ETDurationFastMin.setText("0");
                ETDurationFastSec.setText("0");
            }
        });

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fasting, container, false);
        return view;
    }
}