package serat.maemaeen.notecleanmvvm.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import serat.maemaeen.notecleanmvvm.feature_note.data.data_source.NoteDao
import serat.maemaeen.notecleanmvvm.feature_note.data.data_source.NoteDataBase
import serat.maemaeen.notecleanmvvm.feature_note.data.repository.NoteRepositoryImpl
import serat.maemaeen.notecleanmvvm.feature_note.domain.repository.NoteRepository
import serat.maemaeen.notecleanmvvm.feature_note.domain.use_case.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDb(app: Application): NoteDataBase {
        return Room.databaseBuilder(app, NoteDataBase::class.java, NoteDataBase.DATABASE_NAME)
            .build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDataBase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCase(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }
}