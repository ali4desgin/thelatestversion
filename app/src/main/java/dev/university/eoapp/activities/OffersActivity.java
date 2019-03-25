package dev.university.eoapp.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import dev.university.eoapp.R;
import dev.university.eoapp.adapters.categoriesAdapter;
import dev.university.eoapp.api.RetrofitClient;
import dev.university.eoapp.models.Category;
import dev.university.eoapp.models.category_response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OffersActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private categoriesAdapter adapter;
    private List<Category> categories_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(OffersActivity.this, 2));
        final ProgressDialog progressDialog = new ProgressDialog(OffersActivity.this);
        progressDialog.setMessage("Loading ..");
        progressDialog.show();
        Call<category_response> call = RetrofitClient.getInstance().getApi().getcategories();

        call.enqueue(new Callback<category_response>() {
            @Override
            public void onResponse(Call<category_response> call, Response<category_response> response) {
                progressDialog.dismiss();



                categories_list = response.body().getCategories();
                adapter = new categoriesAdapter(OffersActivity.this, categories_list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<category_response> call, Throwable t) {
                progressDialog.dismiss();

            }
        });
    }
}
