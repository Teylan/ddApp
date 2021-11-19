package com.example.ddapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class DetailsViewModel extends AndroidViewModel {


    private CharacterRepository mRepository;
    private final LiveData<List<Character>> mAllCharacters;
    private MutableLiveData<String> getDetailsId;

    public DetailsViewModel(Application application) {
        super(application);
        mRepository = new CharacterRepository(application);
        mAllCharacters = mRepository.getAllCharacters();
    }

    LiveData<List<Character>> getAllCharacters(){return mAllCharacters;}

    public void insert(Character character){mRepository.insert(character);}

    public MutableLiveData<String> getDetailsId(){
        if (getDetailsId == null) {
            getDetailsId = new MutableLiveData<>();
        }
        return getDetailsId;
    }
}
