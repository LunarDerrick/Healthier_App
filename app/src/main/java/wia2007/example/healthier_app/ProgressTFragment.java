package wia2007.example.healthier_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.function.IntToDoubleFunction;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProgressTFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProgressTFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    GraphView graphView;
    EditText calorieTaken, calorieBurnt;
    Button submitCalories;

    public ProgressTFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProgressTFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProgressTFragment newInstance(String param1, String param2) {
        ProgressTFragment fragment = new ProgressTFragment();
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
        View view = inflater.inflate(R.layout.fragment_progress_t, container, false);

        graphView = view.findViewById(R.id.line_graph_view);
        calorieBurnt = view.findViewById(R.id.calorieBurnt);
        calorieTaken = view.findViewById(R.id.calorieTaken);
        submitCalories = (Button) view.findViewById(R.id.submit_button_progress_tracker);

        String takenValue = calorieTaken.getText().toString();
        String burntValue = calorieBurnt.getText().toString();

        Integer takenValueInt = Integer.parseInt(takenValue);
        Integer burntValueInt = Integer.parseInt(burntValue);

        submitCalories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });


        graphView.addSeries(series);
        return view;
    }
}