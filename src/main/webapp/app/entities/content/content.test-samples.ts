import { IContent, NewContent } from './content.model';

export const sampleWithRequiredData: IContent = {
  id: 25992,
};

export const sampleWithPartialData: IContent = {
  id: 61,
};

export const sampleWithFullData: IContent = {
  id: 11223,
  name: 'chiffonier provided scented',
  description: 'recklessly uselessly',
};

export const sampleWithNewData: NewContent = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
