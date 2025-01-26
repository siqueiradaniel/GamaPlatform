import { IDependency, NewDependency } from './dependency.model';

export const sampleWithRequiredData: IDependency = {
  id: 9593,
};

export const sampleWithPartialData: IDependency = {
  id: 2814,
};

export const sampleWithFullData: IDependency = {
  id: 5984,
};

export const sampleWithNewData: NewDependency = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
