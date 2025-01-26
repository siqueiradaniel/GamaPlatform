import { ILearningPath, NewLearningPath } from './learning-path.model';

export const sampleWithRequiredData: ILearningPath = {
  id: 4275,
};

export const sampleWithPartialData: ILearningPath = {
  id: 11125,
};

export const sampleWithFullData: ILearningPath = {
  id: 27642,
  order: 7682,
};

export const sampleWithNewData: NewLearningPath = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
