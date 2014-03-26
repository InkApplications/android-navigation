package com.inkapplications.android.navigation;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import java.util.Map;

/**
 * Fragment Navigator
 *
 * Navigates between Fragments for a single container
 *
 * @author Maxwell Vandervelde <Max@MaxVandervelde.com>
 */
public class FragmentNavigator
{
    private FragmentManager manager;
    private Map<Class, Fragment> fragments;
    private Class defaultFragment;
    private int fragmentContainer;

    public FragmentNavigator(
        FragmentManager manager,
        int fragmentContainer,
        Map<Class, Fragment> fragments,
        Class defaultFragment
    ) {
        this.manager = manager;
        this.fragments = fragments;
        this.fragmentContainer = fragmentContainer;
        this.defaultFragment = defaultFragment;
    }

    /**
     * Show Fragment
     *
     * Replaces the current view of the container with the fragment class
     * specified.
     *
     * @param target The fragment to show in the container
     */
    public void showFragment(Class target)
    {
        FragmentTransaction transaction = this.manager.beginTransaction();
        Fragment targetFragment = this.fragments.get(target);
        transaction.replace(this.fragmentContainer, targetFragment);
        transaction.commit();
    }

    /**
     * Show Default Fragment
     *
     * Returns the fragment container to its default fragment.
     */
    public void showDefaultFragment()
    {
        this.showFragment(this.defaultFragment);
    }

    /**
     * Get Default Fragment
     *
     * @return The registered default fragment for the navigator
     */
    final public Class getDefaultFragment()
    {
        return this.defaultFragment;
    }
}
