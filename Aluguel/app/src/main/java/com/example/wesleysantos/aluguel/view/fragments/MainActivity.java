package com.example.wesleysantos.aluguel.view.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wesleysantos.aluguel.R;
import com.example.wesleysantos.aluguel.view.adapters.FragmentAdapter;
import com.example.wesleysantos.aluguel.database.DataBase;
import com.example.wesleysantos.aluguel.view.products.ProductFullActivity;
import com.example.wesleysantos.aluguel.view.user.RegisterActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private int count = 4;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView iconSetting;
    private ImageView imageProfile;
    private RelativeLayout rl;
    private TextView nav_user;
    private TextView nav_company;
    private int[] imageResId = {
            R.drawable.ic_format_list_bulleted_black_24dp,
            R.drawable.ic_home_black_24dp,
            R.drawable.ic_stars_black_24dp,
    };

    private LayoutInflater linf;
    private View inflator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set up the ViewPager with the sections adapter.
        viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),getResources().getStringArray(R.array.tabs)));
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(imageResId[i]);
        }
        viewPager.setCurrentItem(1, true);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View hView =  navigationView.getHeaderView(0);

        rl = (RelativeLayout)hView.findViewById(R.id.rlProfileMenu);
        imageProfile = (ImageView)hView.findViewById(R.id.imageProfile);
        nav_user = (TextView)hView.findViewById(R.id.txtName);
        nav_company = (TextView)hView.findViewById(R.id.txtCompany);
        iconSetting = (ImageView)hView.findViewById(R.id.iconSettings);
        rl.setOnClickListener(this);
        imageProfile.setOnClickListener(this);
        nav_company.setOnClickListener(this);
        iconSetting.setOnClickListener(this);
        nav_user.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        DataBase db = new DataBase();

        if (db.isConnected()) {
            if (view == iconSetting) {
                Toast.makeText(getApplicationContext(), "tocou no icone", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "tocou nos outros", Toast.LENGTH_SHORT).show();
            }

        } else {
            linf = LayoutInflater.from(this);
            inflator = linf.inflate(R.layout.dialog_login, null);
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            final AlertDialog alert = builder.create();
            alert.setCancelable(true);
            alert.setView(inflator);
            //alert.create();

            TextView txtNewAccount = (TextView)inflator.findViewById(R.id.txt_new_user);
            txtNewAccount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alert.dismiss();
                    Intent it = new Intent(getApplicationContext(), RegisterActivity.class);
                    startActivity(it);
                }
            });

            TextView txtRecoverPassword = (TextView)inflator.findViewById(R.id.txt_recover_password);
            txtRecoverPassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), "Recover", Toast.LENGTH_SHORT).show();
                }
            });

            TextView btnLogin = (TextView) inflator.findViewById(R.id.btn_login);
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    login();
                }
            });
            alert.show();

        }
    }
    private void login() {
        EditText edtEmail = (EditText)inflator.findViewById(R.id.edt_email);
        EditText edtPassword = (EditText)inflator.findViewById(R.id.edt_password);
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        TextView txtWarningPassword = (TextView)inflator.findViewById(R.id.txt_warning_password);
        TextView txtWarningEmail = (TextView)inflator.findViewById(R.id.txt_warning_email);

        if (TextUtils.isEmpty(email)) {
            txtWarningPassword.setText("");
            edtEmail.requestFocus();
            txtWarningEmail.setText(R.string.txt_warning_email);
            return;
        }
        if (TextUtils.isEmpty(password)) {
            txtWarningEmail.setText("");
            edtPassword.requestFocus();
            txtWarningPassword.setText(R.string.txt_warning_password);
            return;
        }

        DataBase db = new DataBase();
        boolean flag = db.loginUser(email, password);
        if (!flag) {
            txtWarningEmail.setText("");
            edtPassword.requestFocus();
            txtWarningPassword.setText(R.string.txt_warning_login);
            return;
        } else {

        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action_bar, menu);

        MenuItem menuItem = menu.findItem(R.id.testAction);
        menuItem.setIcon(buildCounterDrawable(count, R.drawable.ic_shopping_cart_24));
        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Toast.makeText(getApplicationContext(),"Cliclou no carrinho", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        return true;
    }

    private Drawable buildCounterDrawable(int count, int backgroundImageId) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.counter_menuitem_layout, null);
        view.setBackgroundResource(backgroundImageId);

        if (count == 0) {
            View counterTextPanel = view.findViewById(R.id.counterValuePanel);
            counterTextPanel.setVisibility(View.GONE);
        } else {
            TextView textView = (TextView) view.findViewById(R.id.count);
           // textView.setTextSize(10);
            textView.setText("" + count);
        }

        view.measure(
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());

        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);

        return new BitmapDrawable(getResources(), bitmap);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent it = new Intent(getApplicationContext(), RegisterActivity.class);
            //finish();
            startActivity(it);

        } else if (id == R.id.nav_slideshow) {
            Intent it = new Intent(getApplicationContext(), ProductFullActivity.class);
            //finish();
            startActivity(it);
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
