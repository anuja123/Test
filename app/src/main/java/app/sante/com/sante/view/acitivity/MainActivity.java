package app.sante.com.sante.view.acitivity;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import app.sante.com.sante.R;
import app.sante.com.sante.api.PlacesAPI;
import app.sante.com.sante.util.URLConstants;

public class MainActivity extends ActionBarActivity implements ActionBar.TabListener {
    DrawerLayout mDrawerLayout;

    private Fragment mFragment;
    ListView mDrawerList;
    private ViewPager viewPager ;
    private TabsPagerAdapter mAdapter;
    ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolBar;
    String mTitle = "";

    //private TitleNavigationAdapter mTitleAdapter;
    //private TabsPagerAdapter mTabsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.swipeTabs);
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);


        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);




        // 1st Tab for Bars and Pubs
        ActionBar.Tab tab1 = actionBar.newTab().setText("Bars & Pubs").setTabListener(this);

        actionBar.addTab(tab1);
    //2nd Tab for Night Clubs
        ActionBar.Tab tab2 = actionBar.newTab().setText("Night Clubs").setTabListener(/*new TabListener<NightClubsFragment>(this,"night clubs",NightClubsFragment.class*/this);

        actionBar.addTab(tab2);
        //moveDrawerToTop();
        //initActionBar() ;
        initDrawer();

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
        public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

            public void OnPageScrolled(int arg0 , float arg1 , int arg2) {

            }

        });
        //Quick cheat: Add Fragment 1 to default view
        //onItemClick(null, null, 0, 0);
        makeNetworkRequest();
    }

    public void makeNetworkRequest() {
        PlacesAPI.getPlacesForLocation(this, URLConstants.LOCALE_BLORE);
    }



    private void moveDrawerToTop() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        DrawerLayout drawer = (DrawerLayout) inflater.inflate(R.layout.decor, null); // "null" is important.

        // HACK: "steal" the first child of decor view
        ViewGroup decor = (ViewGroup) getWindow().getDecorView();
        View child = decor.getChildAt(0);
        decor.removeView(child);
        LinearLayout container = (LinearLayout) drawer.findViewById(R.id.drawer_content); // This is the container we defined just now.
        container.addView(child, 0);
        drawer.findViewById(R.id.drawer_list).setPadding(0, getStatusBarHeight(), 0, 0);

        // Make the drawer replace the first child
        decor.addView(drawer);
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private int getContentIdResource() {
        return getResources().getIdentifier("content", "id", "android");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView)menu.findItem(R.id.action_search).getActionView();
        //searchView.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(this,SearchResultsActivity.class)));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
       // mDrawerToggle.syncState();
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private DrawerLayout.DrawerListener createDrawerToggle() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.drawer_open,R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View view) {
                //super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerStateChanged(int state) {
            }
        };
        getSupportActionBar().setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_drawer));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        return mDrawerToggle;
    }
    private void initDrawer() {
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerList = (ListView)findViewById(R.id.drawer_list);
        if(mDrawerLayout == null) {
            Log.e("Errorrrr heree","Tag");
        }
        mDrawerLayout.setDrawerListener(createDrawerToggle());
        ListAdapter adapter = (ListAdapter)(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Side_Menu)));
        mDrawerList.setAdapter(adapter);
        //mDrawerList.setOnItemClickListener(this);
    }



    /*@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mDrawerLayout.closeDrawer(mDrawerList);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ftx = fragmentManager.beginTransaction();
        if(position == 0) {
           // ftx.replace(R.id.main_content, new FragmentFirst());
        } else if(position == 1) {
           // ftx.replace(R.id.main_content, new FragmentSecond());
        }
        ftx.commit();
    }*/

    @Override
    protected void onPostCreate(Bundle savedInstance){
        super.onPostCreate(savedInstance);
        mDrawerToggle.syncState();
    }

    public static class PlaceholderFragment extends Fragment {
        public PlaceholderFragment(){

        }
        @Override
        public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstance){
            View rootView = inflater.inflate(R.layout.fragment,container,false);
            TextView outputTextView = (TextView) rootView.findViewById(R.id.msg);
            outputTextView.setText("hello" + getTag());
            return rootView;
        }

    }
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }
}